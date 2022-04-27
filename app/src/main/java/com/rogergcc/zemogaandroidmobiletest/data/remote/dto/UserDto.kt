package com.rogergcc.zemogaandroidmobiletest.data.remote.dto

import com.rogergcc.zemogaandroidmobiletest.data.local.entity.AddressEntity
import com.rogergcc.zemogaandroidmobiletest.data.local.entity.CompanyEntity
import com.rogergcc.zemogaandroidmobiletest.data.local.entity.GeoEntity
import com.rogergcc.zemogaandroidmobiletest.data.local.entity.UserEntity
import com.rogergcc.zemogaandroidmobiletest.domain.model.Address
import com.rogergcc.zemogaandroidmobiletest.domain.model.Company
import com.rogergcc.zemogaandroidmobiletest.domain.model.Geo
import com.rogergcc.zemogaandroidmobiletest.domain.model.User


data class UserDto(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: AddressDto,
    val phone: String,
    val website: String,
    val company: CompanyDto
) {
    fun toUserEntity(): UserEntity {
        return UserEntity(
            id = id,
            name = name,
            username = username,
            email = email,
            address = AddressEntity(address.street, address.suite, address.city, address.zipcode,
                GeoEntity(address.geo.lat, address.geo.lng)
            ),
            phone = phone,
            website = website,
            company = CompanyEntity(company.name, company.catchPhrase, company.bs)
        )
    }

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
