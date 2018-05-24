package com.lwt.demo6.serviceimpl

import com.lwt.demo6.bean.User
import com.lwt.demo6.service.UserService
import org.springframework.stereotype.Service
import com.lwt.demo6.dao.UserDao
import com.mongodb.client.result.DeleteResult
import com.mongodb.client.result.UpdateResult
import org.springframework.beans.factory.annotation.Autowired



@Service("userService")
class UserServiceImpl:UserService {



    @Autowired
    private lateinit var  userDao: UserDao

    override fun getAll(): List<User> {

        return userDao.getAll()
    }
    override fun insert(user: User) {
        return userDao.insert(user)
    }
    override fun findById(_id: String): User? {
        return userDao.findById(_id)
    }
    override fun updataUser(_id: String,name:String): UpdateResult {
        return userDao.updataUser(_id,name)
    }
    override fun deleteUser(_id: String): DeleteResult {
        return userDao.deleteUser(_id)
    }
}