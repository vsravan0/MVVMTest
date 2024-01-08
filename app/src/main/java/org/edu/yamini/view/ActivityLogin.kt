package org.edu.yamini.view

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import org.edu.yamini.databinding.LayoutLoginBinding
import org.edu.yamini.viewmodel.AuthListener
import org.edu.yamini.viewmodel.AuthModel

class ActivityLogin : ComponentActivity() , AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : LayoutLoginBinding = LayoutLoginBinding.inflate(layoutInflater);
        setContentView(binding.root)
        val authModel = ViewModelProvider(this).get(AuthModel::class.java)
      //  val authModel : AuthModel = AuthModel()
        binding.authmodel = authModel
        authModel.authListener = this

        
}

    override fun onStarted() {
        Log.d("Activity Login", "onStarted")
    }

    override fun onSuccess() {
        Log.d("Activity Login", "onSuccess")
    }

    override fun onFailure(message: String) {
        Log.d("Activity Login", "onFailure "+message)
    }


}