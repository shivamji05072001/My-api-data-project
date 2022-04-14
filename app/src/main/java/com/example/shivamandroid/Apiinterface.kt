package com.example.apidata

import retrofit2.Call
import retrofit2.http.GET

interface Apiinterface {
    @GET("easygautam/data/users")
    fun getdata():Call<List<Users.UsersItem>>
}