package com.example.sportz.network

import com.example.sportz.domain.SportsModel
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

import retrofit2.http.GET


private const val BASE_URL = "https://cricket.yahoo.net/sifeeds/cricket/live/json/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()


interface SportZApiService{

    @GET("nzin01312019187360.json")
    fun getTeamsDetails() : Deferred<SportsModel>

}

object SportZApi {
    val retrofitService: SportZApiService by lazy {

        retrofit.create(SportZApiService::class.java)

    }

}
