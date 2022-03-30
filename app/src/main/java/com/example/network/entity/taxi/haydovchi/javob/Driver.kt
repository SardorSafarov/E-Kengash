package com.example.network.entity.taxi.haydovchi.javob

data class Driver(
    val avatar: String,
    val balance: String,
    val bio: Any,
    val birthday: String,
    val created_at: String,
    val driver: DriverX,
    val email: Any,
    val email_verified_at: Any,
    val gender: String,
    val id: Int,
    val is_terms: String,
    val name: String,
    val phone: String,
    val phone_verified_at: String,
    val reviews: List<Any>,
    val role_id: Int,
    val settings: Settings,
    val updated_at: String
)