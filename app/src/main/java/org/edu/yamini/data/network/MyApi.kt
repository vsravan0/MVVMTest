package org.edu.yamini.data.network

import org.edu.yamini.data.db.entities.Users
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MyApi {

    @GET("users")  // https://jsonplaceholder.typicode.com/users
//    fun getUsers() : Call<ResponseBody>
    fun getUsers() : Call<List<Users>>

    // Coroutine specific
    @GET("users")
    suspend  fun getUsersResponse() : Response<List<Users>>

    companion object {
        operator  fun invoke() : MyApi {

            return  Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
               .create(MyApi::class.java)
        }
    }
}