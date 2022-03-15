package com.example.room.repository

import androidx.lifecycle.LiveData
import com.example.room.dao.UserDao
import com.example.room.roomEntity.UserEntity

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<UserEntity>> = userDao.readUser()

    suspend fun insertUser(user: UserEntity) {
        userDao.insertUser(user)
    }

    suspend fun deleteUser(){
        userDao.deleteUser()
    }
}