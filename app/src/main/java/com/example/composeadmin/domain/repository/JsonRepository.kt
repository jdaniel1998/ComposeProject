package com.example.composeadmin.domain.repository

import com.example.composeadmin.utils.Resource
import kotlinx.coroutines.flow.Flow
import org.json.JSONObject

interface JsonRepository {

    suspend fun getJsonFromNetwork(): Resource<out JSONObject>

    suspend fun getJsonFromLocal(): JSONObject?

    suspend fun saveJson(json: JSONObject)

}