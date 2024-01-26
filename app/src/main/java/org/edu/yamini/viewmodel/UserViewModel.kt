package org.edu.yamini.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.edu.yamini.data.Users
import org.edu.yamini.data.network.MyApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel : ViewModel() {

    var TAG = "UserViewModel"
    val userList  = MutableLiveData<List<Users>>()
    val erroMessage = MutableLiveData<String>()

    fun onLoadUsers(view : View) {

        Log.d(TAG, "onLoad User");

        MyApi().getUsers()
            .enqueue(object : Callback<List<Users>> {

                override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {
                    Log.d(TAG, " onResponse success "+response)
                    userList.postValue(response.body())
                }

                override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                    Log.d(TAG, " onFailure "+t.message)
                    erroMessage.postValue(t.message)
                }

            })
    }
}