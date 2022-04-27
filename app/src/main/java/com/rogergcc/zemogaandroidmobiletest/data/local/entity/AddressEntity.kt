package com.rogergcc.zemogaandroidmobiletest.data.local.entity


data class AddressEntity(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: GeoEntity
)
