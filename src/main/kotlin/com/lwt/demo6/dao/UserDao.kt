package com.lwt.demo6.dao

import com.lwt.demo6.bean.User
import com.mongodb.client.result.DeleteResult
import com.mongodb.client.result.UpdateResult

interface UserDao {
    fun getAll():List<User>
    fun insert(user:User)
    fun findById(_id:String):User?
    fun updataUser(_id:String,name:String): UpdateResult
    fun deleteUser(_id:String): DeleteResult

}