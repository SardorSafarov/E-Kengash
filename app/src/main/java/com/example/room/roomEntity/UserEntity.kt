package com.example.room.roomEntity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_table")
class UserEntity(
    @PrimaryKey(autoGenerate = true)
    var _id:Int=0,
    var full_name:String="",
    var phone:String="",
    var token:String?=null,
    var balans:String=""
)