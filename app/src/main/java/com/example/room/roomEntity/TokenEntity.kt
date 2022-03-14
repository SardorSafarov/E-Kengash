package com.example.room.roomEntity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "token_table")
class TokenEntity(
    @PrimaryKey(autoGenerate = true)
    var _id:Int=0,
    var token:String?=null
)