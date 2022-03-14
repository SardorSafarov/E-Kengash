package com.example.room.repository

import androidx.lifecycle.LiveData
import com.example.room.dao.TokenDao
import com.example.room.roomEntity.TokenEntity

class TokenRepository(private val tokenDao: TokenDao) {

    val readAllData: LiveData<List<TokenEntity>> = tokenDao.readToken()

    suspend fun insertToken(token: TokenEntity) {
        tokenDao.insertToken(token)
    }

    suspend fun deleteToken(){
        tokenDao.deleteToken()
    }
}