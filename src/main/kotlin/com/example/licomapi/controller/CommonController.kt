package com.example.licomapi.controller

import com.example.licomapi.entity.BaseBean
import com.example.licomapi.entity.CommonBean
import com.example.licomapi.utils.JsonUtils.fromJson
import com.example.licomapi.utils.JsonUtils.toJson
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CommonController {

    @RequestMapping("/")
    fun home():String{
        return "Hi, see common"
    }

    @RequestMapping("/common")
    fun common(@RequestBody jsonString: CommonBean?):BaseBean{
        var result = BaseBean(-1, "请求参数错误")
        jsonString?.apply {
            try {
                val commonBean = this//jsonString.fromJson<CommonBean>()
                result.apply {
                    code = commonBean.responseCode?:200
                    msg = commonBean.responseMsg?:"请求成功"
                    data = commonBean.responseData
                }
                if (commonBean.delayMillSeconds>0){
                    Thread.sleep(commonBean.delayMillSeconds)
                }
            }catch (e:Exception){
                println("Error: ${e.toString()}")
                result.msg = e.toString()
            }
        }
        println()
        println("/common ***** start *****")
        println("请求参数：")
        println(jsonString?.toJson())
        println("返回结果：")
        println(result.toJson())
        println("/common ***** end *****")
        println()
        return result
    }

}