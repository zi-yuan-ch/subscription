package com.helios.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/hello")
open class TestController  {

    @RequestMapping(value = ["/user"], method = [RequestMethod.GET])
    @ResponseBody
    @Throws(Exception::class)
    fun focusMapAlbumIds(@RequestParam signature:String?,
                         @RequestParam timestamp:String?,
                         @RequestParam nonce:String?,
                         @RequestParam echostr:String?): String {
       return echostr ?: ""
    }
}