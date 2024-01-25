package org.edu.yamini.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import okhttp3.ResponseBody
import org.edu.yamini.data.Users
import org.edu.yamini.data.network.MyApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {

    fun  UserRepos() : LiveData<List<Users>> {

        //val responseUsersRepos = MutableLiveData<String>()
        val responseUsersList = MutableLiveData<List<Users>>()

        MyApi().getUsers()
            .enqueue(object : Callback<List<Users>> {
                override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {


                    Log.d("UserRepos 1","onResonse response -> "+response)
                    //Log.d("UserRepos 2","onResonse body toString "+response.body()?.toString())
                    Log.d("UserRepos 2","onResonse body  "+response.body())

                }

                override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                    Log.d("UserRepos ","onFailure "+t.message)

                }

            })

        return  responseUsersList
    }

}