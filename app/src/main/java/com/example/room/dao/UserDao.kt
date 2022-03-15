package com.example.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.room.roomEntity.UserEntity


@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: UserEntity)

    @Query("select * from user_table")
    fun readUser(): LiveData<List<UserEntity>>

    @Query("delete from user_table")
    suspend fun deleteUser()
}