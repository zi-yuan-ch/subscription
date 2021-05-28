package com.helios.controller

import com.helios.domain.TextMessage
import com.helios.service.DtkService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.util.regex.Pattern

@Controller
@RequestMapping("/message/replay")
open class MessageReplayController {

    @Autowired
    private lateinit var dtkService: DtkService

    @RequestMapping(value = [""], method = [RequestMethod.GET])
    @ResponseBody
    @Throws(Exception::class)
    fun get(@RequestParam signature: String?,
            @RequestParam timestamp: String?,
            @RequestParam nonce: String?,
            @RequestParam echostr: String?): String {
        println("received one request,method:get")
        return echostr ?: ""
    }

    @RequestMapping(value = [""], method = [RequestMethod.POST],  consumes = [MediaType.TEXT_XML_VALUE])
    @ResponseBody
    @Throws(Exception::class)
    fun post(@RequestBody req: TextMessage): String {
        println("received one request,method:post")
        val content = req.content ?: ""
        val respContent = dtkService.twd2twd(content)
        val errorContent =  "很抱歉，我们现在只支持解析淘口令，其他文本信息暂时无法理解，小多正在努力学习中，请谅解！"
        var template = errorContent
        val itemId = respContent?.itemId
        if(itemId != null ) {
            val itemInfo = dtkService.getItemInfo(itemId)
            itemInfo?.let {
                template = """
                ${respContent.title}
                【原价】${itemInfo.reservePrice}
                【优惠价】${itemInfo.zkFinalPrice}
                【返利】
            """.trimIndent()
            }

        }

        return "<xml>\n" +
                " <ToUserName>${req.fromUserName}</ToUserName>\n" +
                " <FromUserName>${req.toUserName}</FromUserName>\n" +
                " <CreateTime>${req.createTime}</CreateTime>\n" +
                " <MsgType><![CDATA[text]]></MsgType>\n" +
                " <Content><![CDATA[${respContent}]]></Content>\n" +
                " <MsgId>${req.msgId}</MsgId>\n" +
                "</xml>"
    }


}