package com.lwt.demo6.controller

import com.lwt.demo6.bean.BaseR
import com.lwt.demo6.bean.User
import com.lwt.demo6.err.UserErr
import com.lwt.demo6.serviceimpl.UserServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/user")
 class UserController {

    @Autowired
     lateinit var userService: UserServiceImpl

    @GetMapping("/getAll")
     fun getAllUser(): BaseR<List<User>> {

        var baseR=BaseR<List<User>>()

        baseR.data=userService.getAll()

         return baseR
    }

    @PostMapping("/insert")
     fun insert(@RequestParam("name") name:String,@RequestParam("age") age:Int,@RequestParam("gender") gender:Int): BaseR<User> {

        var baseR=BaseR<User>()

        var user=User(null,name,age,gender)

        userService.insert(user)

        baseR.data=user

        return baseR
    }
    @PostMapping("/delete")
     fun delete(@RequestParam("_id") _id:String): BaseR<Boolean> {

        var baseR=BaseR<Boolean>()

        when (userService.deleteUser(_id).deletedCount) {
            0L -> {
                baseR=UserErr.USER_NOTFIND
            }

            else -> {
                baseR.data=true
            }
        }

        return baseR
    }
    @PostMapping("/updata")
     fun updata(@RequestParam("_id") _id:String,@RequestParam("name") name:String): BaseR<Boolean> {

        var baseR=BaseR<Boolean>()

        when (userService.updataUser(_id,name).modifiedCount) {
            0L -> {

                baseR=UserErr.USER_NOTFIND
            }

            else -> {
                baseR.data=true
            }
        }

        return baseR
    }
    @GetMapping("/findbyid")
     fun findById(@RequestParam("_id") _id:String): BaseR<User> {

        var baseR=BaseR<User>()
        var user = userService.findById(_id)

        if (user == null){
            baseR.code=202
            baseR.mesage="用户找不到"
        }

        baseR.data = user
        return baseR
    }





}