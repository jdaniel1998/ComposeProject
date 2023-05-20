package com.example.composeadmin.data.network

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface JsonApiClient {

    //Api endpoint
    @GET("getStaticsv2.1.php")
    suspend fun getJsonFromNetwork(): Response<ResponseBody>

}