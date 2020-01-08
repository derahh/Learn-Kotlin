package com.derahh.retrofitbasic.service

import com.derahh.retrofitbasic.model.User
import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET("/users")
    fun fetchAllUsers(): Call<List<User>>
}