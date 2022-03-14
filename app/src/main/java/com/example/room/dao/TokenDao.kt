package com.example.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.room.roomEntity.TokenEntity


@Dao
interface TokenDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertToken(user: TokenEntity)

    @Query("select * from token_table")
    fun readToken(): LiveData<List<TokenEntity>>

    @Query("delete from token_table")
    suspend fun deleteToken()
}