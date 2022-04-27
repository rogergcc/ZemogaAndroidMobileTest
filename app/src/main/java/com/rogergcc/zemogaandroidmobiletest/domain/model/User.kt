package com.rogergcc.zemogaandroidmobiletest.domain.model

data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company
) {
    fun toUser(): User {
        return User(
            id = id,
            name = name,
            username = username,
            email = email,
            address = Address(address.street, address.suite, address.city, address.zipcode,
                Geo(address.geo.lat, address.geo.lng)
            ),
            phone = phone,
            website = website,
            company = Company(company.name, company.catchPhrase, company.bs)
        )
    }
}
