package com.lwt.demo6.bean

data class BaseR<T>(var code:Int,var mesage:String?,var data:T?) {

    constructor(code: Int):this(code,"ok",null)

    constructor():this(200)
}