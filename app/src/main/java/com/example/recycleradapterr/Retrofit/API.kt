package com.example.recycleradapterr.Retrofit

import com.example.recycleradapterr.Model.NewsData
import com.example.recycleradapterr.utils.CommonKeys.API_HOST
import com.example.recycleradapterr.utils.CommonKeys.API_KEY
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface API {

    @GET("/latest")
    @Headers(
        "X-RapidAPI-Key:$API_KEY",
        "X-RapidAPI-Host:$API_HOST"
    )
    fun getData(): Call<ResponseBody>
}