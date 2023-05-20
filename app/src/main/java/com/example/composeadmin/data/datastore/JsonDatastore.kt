package com.example.composeadmin.data.datastore

import kotlinx.coroutines.flow.Flow
import org.json.JSONObject

interface JsonDatastore {

    suspend fun saveJson(json: JSONObject)

    suspend fun getJson(): JSONObject?

}