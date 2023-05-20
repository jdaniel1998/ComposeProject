package com.example.composeadmin.data

import com.example.composeadmin.data.datastore.JsonDatastore
import com.example.composeadmin.data.network.JsonApiClient
import com.example.composeadmin.utils.Resource
import com.example.composeadmin.domain.repository.JsonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import org.json.JSONObject
import javax.inject.Inject

class JsonRepositoryImpl @Inject constructor(
    private val api: JsonApiClient,
    private val jsonDatastore: JsonDatastore
) : JsonRepository {

    override suspend fun getJsonFromNetwork(): Resource<out JSONObject> {
        val response = api.getJsonFromNetwork()
        return if (response.isSuccessful)
            Resource.Success(JSONObject(response.body()?.string() ?: ""))
        else
            Resource.Error(response.message())
    }

    override suspend fun getJsonFromLocal(): JSONObject? = jsonDatastore.getJson()

    override suspend fun saveJson(json: JSONObject) {
        jsonDatastore.saveJson(json)
    }
}