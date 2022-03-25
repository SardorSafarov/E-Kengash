package com.example.network.entity.profil.user

data class Data(
    val userData: UserData,
    val userInfo: UserInfo,
    val userPassport: UserPassport,
    val usersOrg: UsersOrg,
    val usersSurveyAns: List<UsersSurveyAn>
)