package com.rogergcc.zemogaandroidmobiletest.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter


import com.rogergcc.zemogaandroidmobiletest.data.local.entity.AddressEntity
import com.rogergcc.zemogaandroidmobiletest.data.local.entity.CompanyEntity
import com.rogergcc.zemogaandroidmobiletest.data.local.entity.GeoEntity
import com.rogergcc.zemogaandroidmobiletest.data.utils.JsonParser

@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {

    @TypeConverter
    fun fromAddressJson(json: String): AddressEntity {
        return jsonParser
            .fromJson<AddressEntity>(
                json,
                AddressEntity::class.java) ?:
                AddressEntity("", "", "", "", GeoEntity("", ""))
    }

    @TypeConverter
    fun fromJsonAddress(addressEntity: AddressEntity): String {
        return jsonParser
            .toJson<AddressEntity>(
                addressEntity,
                AddressEntity::class.java
            ) ?: ""
    }

    @TypeConverter
    fun fromCompanyJson(json: String): CompanyEntity {
        return jsonParser
            .fromJson<CompanyEntity>(
                json,
                CompanyEntity::class.java) ?:
        CompanyEntity("","","")
    }

    @TypeConverter
    fun fromJsonCompany(companyEntity: CompanyEntity): String {
        return jsonParser
            .toJson<CompanyEntity>(
                companyEntity,
                CompanyEntity::class.java
            ) ?: ""
    }

}