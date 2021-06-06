package com.helios.service

import com.google.gson.Gson
import com.helios.domain.DtkUrlConst
import com.helios.dtk.*
import com.taobao.api.DefaultTaobaoClient
import com.taobao.api.request.TbkItemInfoGetRequest
import com.taobao.api.response.TbkItemInfoGetResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat
import java.util.*


@Service
class DtkService {
    @Value("\${spring.dtk.app-key}")
    private lateinit var appKey: String
    @Value("\${spring.dtk.app-secret}")
    private lateinit var appSecret: String
    @Value("\${spring.dtk.app-pid}")
    private lateinit var pid: String
    private val taobaoUrl: String = "http://gw.api.taobao.com/router/rest"
    private val taobaoAppKey = "32672842"
    private val taobaoAppSecret = "9c20b5311edaddc90204b63c8928c202"

    private val taobaoClient: DefaultTaobaoClient by lazy {
        DefaultTaobaoClient(taobaoUrl, taobaoAppKey, taobaoAppSecret)
    }

    /**
     * 淘口令转淘口令
     */
    fun twd2twd(content: String): DtkTwd2TwdData? {
        val url = DtkUrlConst.TWD_TO_TWD
        val paraMap = TreeMap<String, String>()
        paraMap["appKey"] = appKey
        paraMap["version"] = "v1.0.0"
        paraMap["content"] = content
        paraMap["pid"] = pid
        val data: String = ApiClient.sendReq(url, appSecret, paraMap)
        val resp = Gson().fromJson(data, DtkTwd2TwdResp::class.java)
        return resp.data
    }

    /**
     * 淘口令万能解析
     */
    fun tbMasterParse(content: String): TbParseContentData? {
        val url = DtkUrlConst.TB_PARSE
        val paraMap = TreeMap<String, String>()
        paraMap["version"] = "v1.0.0"
        paraMap["appKey"] = appKey
        paraMap["content"] = content
        val data = ApiClient.sendReq(url, appSecret, paraMap) ?: return null
        return Gson().fromJson(data, TbParseContentResp::class.java).data
    }

    /**
     * 淘口令生成
     */
    fun genTwd(itemUrl: String, userId: String): String {
        val url = DtkUrlConst.CREATE_TAOKOULING
        val paraMap = TreeMap<String, String>()
        paraMap["version"] = "v1.0.0"
        paraMap["appKey"] = appKey
//        paraMap["text"] = "hello world"
        paraMap["url"] = itemUrl
        paraMap["userId"] = userId
//        paraMap["logo"] = "xxxxx"
        return ApiClient.sendReq(url, appSecret, paraMap)
    }

    /**
     * 商品详情获取
     */
    fun getItemInfo(itemId: Long): TbkItemInfoGetResponse.NTbkItem? {
        val req = TbkItemInfoGetRequest()
        req.numIids = itemId.toString()
        req.platform = 1L
        val resp = taobaoClient.execute(req)
        return resp.results.firstOrNull()
    }

    /**
     * 订单详情获取
     */
    fun getOrderDetails(start: Date, end: Date) {
        val df = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val url = DtkUrlConst.ORDER_DETAILS
        val paraMap = TreeMap<String, String>()
        paraMap["version"] = "v1.0.0"
        paraMap["appKey"] = appKey
//        paraMap["pageSize"] = "2"
        paraMap["startTime"] = df.format(start)
        paraMap["endTime"] = df.format(end)
        val data = ApiClient.sendReq(url, appSecret, paraMap)
        println(data)
    }

    fun getPrivilegeLink() {

    }

}