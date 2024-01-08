package org.edu.yamini.data.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MyApi {

    @GET("users")  // https://jsonplaceholder.typicode.com/users
    fun getUsers() : Call<ResponseBody>

    companion object {
        operator  fun invoke() : MyApi {

            return  Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
               .create(MyApi::class.java)
        }
    }
}