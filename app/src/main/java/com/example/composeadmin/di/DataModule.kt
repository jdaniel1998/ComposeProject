package com.example.composeadmin.di

import android.content.Context
import com.example.composeadmin.data.datastore.JsonDatastore
import com.example.composeadmin.data.datastore.JsonDatastoreImpl
import com.example.composeadmin.data.network.JsonApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://bothapp.online/bwfquci12n8734uvjnqigqhj51093ksvlzdnDNVmxmZnfuiyq3r89e/") //Api base url
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideJsonApiClient(retrofit: Retrofit): JsonApiClient =
        retrofit.create(JsonApiClient::class.java)

    @Singleton
    @Provides
    fun provideJsonDatastore(@ApplicationContext context: Context): JsonDatastore = JsonDatastoreImpl(context)

}