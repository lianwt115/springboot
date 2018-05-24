package com.lwt.demo6.bean

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "w_user")
data class User(
        @Id
        var _id:String?=null,
        var name:String,
        var age:Int,
        var gender:Int
        ) {
    constructor():this(null,"",-1,-1)
}