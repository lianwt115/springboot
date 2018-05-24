package com.lwt.demo6.daoimpl

import com.lwt.demo6.bean.User
import com.lwt.demo6.dao.UserDao
import com.mongodb.client.result.DeleteResult
import com.mongodb.client.result.UpdateResult
import org.springframework.stereotype.Repository
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators
import com.sun.deploy.util.SearchPath.findOne
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import sun.text.normalizer.UCharacter.getAge
import org.springframework.data.mongodb.core.query.Update




@Repository("userDao")
class UserDaoImpl:UserDao {



    @Autowired
    private  lateinit var  mongoTemplate: MongoTemplate

    override fun getAll(): List<User> {

        return mongoTemplate.findAll(User::class.java)
    }

    override fun insert(user: User) {

        return mongoTemplate.insert(user)

    }

    override fun findById(_id: String): User? {

        val query = Query(Criteria.where("_id").`is`(_id))

        return mongoTemplate.findOne(query,User::class.java)

    }

    override fun updataUser(_id: String,name:String): UpdateResult {

        val criteria = Criteria.where("_id").`is`(_id)
        val query = Query(criteria)
        val update = Update.update("name", name)
        return mongoTemplate.updateMulti(query, update, User::class.java)

    }

    override fun deleteUser(_id: String): DeleteResult {
        val criteria = Criteria.where("_id").`is`(_id)
        val query = Query(criteria)
        return mongoTemplate.remove(query,User::class.java)

    }

}