package com.rogergcc.zemogaandroidmobiletest.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.rogergcc.zemogaandroidmobiletest.data.local.model.DataModel

data class GetDataDto(
    @SerializedName("result")
    val photo: String
)

fun GetDataDto.toDataModel(): DataModel {
    return DataModel(photo = this.photo)
}
