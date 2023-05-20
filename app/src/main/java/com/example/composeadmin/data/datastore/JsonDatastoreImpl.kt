package com.example.composeadmin.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import org.json.JSONObject
import javax.inject.Inject

const val DataStore_NAME = "JSON"

val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = DataStore_NAME)

class JsonDatastoreImpl @Inject constructor(private val context: Context) : JsonDatastore {

    private val JSON_STRING = stringPreferencesKey("JSON_STRING")

    override suspend fun saveJson(json: JSONObject) {
        context.datastore.edit {
            it[JSON_STRING] = Gson().toJson(json)
        }
    }

    override suspend fun getJson(): JSONObject? {
        val preferences = context.datastore.data.first()
        return Gson().fromJson(preferences[JSON_STRING], JSONObject::class.java)
    }
}