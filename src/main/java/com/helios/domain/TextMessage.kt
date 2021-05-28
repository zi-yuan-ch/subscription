package com.helios.domain

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JacksonXmlRootElement(localName = "xml")
class TextMessage {
    @JacksonXmlProperty(localName = "ToUserName")
    var toUserName: String? = null
    @JacksonXmlProperty(localName = "FromUserName")
    var fromUserName: String? = null
    @JacksonXmlProperty(localName = "CreateTime")
    var createTime: Long? = null
    @JacksonXmlProperty(localName = "MsgType")
    var msgType: String? = null
    @JacksonXmlProperty(localName = "Content")
    var content: String? = null
    @JacksonXmlProperty(localName = "MsgId")
    var msgId: String? = null


}