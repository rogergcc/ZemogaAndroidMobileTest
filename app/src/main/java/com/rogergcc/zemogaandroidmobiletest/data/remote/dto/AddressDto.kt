package com.rogergcc.zemogaandroidmobiletest.data.remote.dto


data class AddressDto(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: GeoDto
)
