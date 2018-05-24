package com.lwt.demo6.err

import com.lwt.demo6.bean.BaseR

class UserErr {

    companion object {

        var USER_NOTFIND=BaseR<Boolean>(201,"用户未找到",false)

    }







}