package com.example.licomapi.entity

data class CommonBean(
    var delayMillSeconds: Long=0,
    var reqData: Any?=null,
    var responseCode: Int?=null,
    var responseMsg: String?=null,
    var responseData: Any?=null,
)

data class BaseBean(
    var code: Int,
    var msg: String,
    var data: Any?=null,
)
