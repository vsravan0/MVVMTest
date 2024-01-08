package org.edu.yamini.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import okhttp3.ResponseBody
import org.edu.yamini.data.network.MyApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {

    fun  UserRepos() : LiveData<String> {
        val responseUsersRepos = MutableLiveData<String>()

        MyApi().getUsers()
            .enqueue(object :Callback<ResponseBody> {
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                      if(response.isSuccessful) {
                          responseUsersRepos.value = response.body()?.toString()
                          Log.d("UserRepos 1","onResonse response -> "+response)
                          Log.d("UserRepos 1","onResonse raw -> "+response.raw())
                          Log.d("UserRepos 1","onResonse message -> "+response.message())
                          Log.d("UserRepos 1","onResonse body -> "+response.body()?.toString())
                          Log.d("UserRepos 1","onResonse code -> "+response.code())
                      } else {
                          responseUsersRepos.value = response.errorBody()?.toString()
                          Log.d("UserRepos 1"," fail onResonse  "+response)

                      }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                     responseUsersRepos.value= t.message
                    Log.d("UserRepos "," onFailure  "+t.message)
                }
            })
        Log.d("UserRepository ", "final userrepo "+responseUsersRepos.toString());
        return  responseUsersRepos;
    }

}