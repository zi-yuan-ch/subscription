package com.helios.service

import com.google.gson.Gson
import com.helios.domain.DtkUrlConst
import com.helios.dtk.*
import com.taobao.api.DefaultTaobaoClient
import com.taobao.api.request.TbkItemInfoGetRequest
import com.taobao.api.response.TbkItemInfoGetResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
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

    fun tbMasterParse(content: String): TbParseContentData? {
        val url = DtkUrlConst.TB_PARSE
        val paraMap = TreeMap<String, String>()
        paraMap["version"] = "v1.0.0"
        paraMap["appKey"] = appKey
        paraMap["content"] = content
        val data = ApiClient.sendReq(url, appSecret, paraMap)
        return Gson().fromJson(data, TbParseContentResp::class.java).data
    }

    fun getItemInfo(itemId: Long): TbkItemInfoGetResponse.NTbkItem? {
        val req = TbkItemInfoGetRequest()
        req.numIids = itemId.toString()
        req.platform = 1L
        val resp = taobaoClient.execute(req)
        return resp.results.firstOrNull()
    }

    fun getOrderDetails() {
        val url = "https://openapi.dataoke.com/api/tb-service/get-order-details"
        val paraMap = TreeMap<String, String>()
        paraMap["version"] = "v1.0.0"
        paraMap["appKey"] = appKey
        paraMap["pageSize"] = "2"
        paraMap["endTime"] = "2021-05-26 12:00:00"
        paraMap["startTime"] = "2021-05-26 11:00:00"
        val data = ApiClient.sendReq(url, appSecret, paraMap)
        println(data)
    }

}