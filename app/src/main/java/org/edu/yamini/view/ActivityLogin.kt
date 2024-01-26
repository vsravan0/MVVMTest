package org.edu.yamini.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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

    fun gotoNextActivity() {

        var intent : Intent
        intent = Intent(this,ActivityUsers::class.java )
        startActivity(intent)

    }

    override fun onStarted() {
        Log.d("Activity Login", "onStarted")
    }

    override fun onSuccess() {
        Log.d("Activity Login", "onSuccess")
        Toast.makeText(applicationContext, "Success", Toast.LENGTH_SHORT).show()
    }

    override fun onFailure(message: String) {
        Log.d("Activity Login", "onFailure "+message)
    }


}