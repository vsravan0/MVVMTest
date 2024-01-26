package org.edu.yamini.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import org.edu.yamini.data.repositories.UserRepository

class UserViewModel(
    private val repository: UserRepository
) : ViewModel() {

    var TAG = "UserViewModel"
    var userDataListener : UserDataListener ? = null

    fun onLoadUsers(view : View) {

        Log.d(TAG, "onLoadUsers");
        val response = repository.UserRepos()
        userDataListener?.onSuccess(response)
    }
}