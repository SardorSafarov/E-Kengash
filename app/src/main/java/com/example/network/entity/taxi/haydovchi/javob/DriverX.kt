package com.example.network.entity.taxi.haydovchi.javob

data class DriverX(
    val allow_packages: Int,
    val allow_pets: Int,
    val allow_smoke: Int,
    val approved_at: String,
    val car_photo: String,
    val car_year: Int,
    val color: Color,
    val color_id: Int,
    val created_at: String,
    val deleted_at: Any,
    val driver_license: String,
    val id: Int,
    val license: Any,
    val make: Make,
    val make_id: Int,
    val model: Model,
    val model_id: Int,
    val rejected_at: Any,
    val reviewer_comment: Any,
    val updated_at: String,
    val user_id: Int
)