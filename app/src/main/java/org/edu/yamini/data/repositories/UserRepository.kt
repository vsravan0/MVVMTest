package org.edu.yamini.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import org.edu.yamini.data.db.AppDatabase
import org.edu.yamini.data.db.entities.Users
import org.edu.yamini.data.network.MyApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository (
    private val api : MyApi,
    private val db : AppDatabase
){
    private var TAG ="UserRepository";

    fun  UserRepos() : LiveData<List<Users>> {

        Log.d(TAG,"UserRepos")
        val responseUsersList = MutableLiveData<List<Users>>()
        api.getUsers()
            .enqueue(object : Callback<List<Users>> {
                override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {
                    Log.d(TAG,"onResonse body "+response.body())
                    responseUsersList.value = response.body()
                    Log.d(TAG,"onResonse Store Data ")
              //      db.getuserDao().upsert(response.body()!!)
                }

                override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                    Log.d(TAG,"onFailure "+t.message)
                }
            })
        return  responseUsersList
    }


}