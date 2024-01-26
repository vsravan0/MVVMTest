package org.edu.yamini.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import org.edu.yamini.data.repositories.UserRepository

class AuthModel : ViewModel() {

    var userName: String? = null
    var password: String? = null

    var authListener : AuthListener ? = null

    fun onLogin(view : View) {

        Log.d("AuthModel", "onLogin unm "+userName+" pwd "+password)

        // We received click
      /*  if(userName.isNullOrEmpty() || password.isNullOrEmpty()) {
            // Error
            authListener?.onFailure("values are empty")
            return
        } */

     //   val userResponse = UserRepository().UserRepos()
      //  authListener?.onSuccess()
        // Success
    }

    fun onSignup(view : View) {
        // We received click
    }


}