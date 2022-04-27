package com.rogergcc.zemogaandroidmobiletest.repository

import com.rogergcc.zemogaandroidmobiletest.data.local.model.DataModel
import com.rogergcc.zemogaandroidmobiletest.util.Resource

interface DataRepo {
    suspend fun getData(): Resource<DataModel>
}
