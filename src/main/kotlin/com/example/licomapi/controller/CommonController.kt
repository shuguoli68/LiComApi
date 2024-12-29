package com.example.licomapi.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CommonController {

    @RequestMapping("/")
    fun home():String{
        return "Hi, see common"
    }

    @RequestMapping("/common")
    fun common(jsonString: String):String{
        return jsonString
    }

}