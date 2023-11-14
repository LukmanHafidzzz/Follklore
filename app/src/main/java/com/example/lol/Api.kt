package com.example.loginregister

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface Api {
    @GET ("everything")
    @Headers ("Authorization: token 9b620e58f89e460abdfe7fb76d7ddb39")
    fun getSearchNews (@Query("q") topic : String): Call<NewsResponse>
}