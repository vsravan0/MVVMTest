package org.edu.yamini.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel

class AuthModel : ViewModel() {

    val userName: String? = null
    val password: String? = null

    var authListener : AuthListener ? = null

    fun onLogin(view : View) {

        Log.d("AuthModel", "onLogin unm "+userName+" pwd "+password)

        // We received click
        if(userName.isNullOrEmpty() || password.isNullOrEmpty()) {
            // Error
            authListener?.onFailure("values are empty")
            return
        }
        // Success
    }

    fun onSignup(view : View) {
        // We received click
    }


}