package org.edu.yamini.view

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import org.edu.yamini.databinding.LayoutUsersBinding
import org.edu.yamini.viewmodel.UserAdapter
import org.edu.yamini.viewmodel.UserDataListener
import org.edu.yamini.viewmodel.UserViewModel

class ActivityUsers : ComponentActivity() , UserDataListener{

    private val TAG = "ActivityUsers";
    private lateinit var mUserBinding : LayoutUsersBinding
    private lateinit var mUserViewModel : UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mUserBinding = LayoutUsersBinding.inflate(layoutInflater)
        setContentView(mUserBinding.root)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserBinding.userviewmodel = mUserViewModel
        val adapter = UserAdapter()
        mUserBinding.recycleview.adapter = adapter

       val lm = LinearLayoutManager(this)
        lm.orientation = LinearLayoutManager.VERTICAL
        mUserBinding.recycleview.layoutManager = lm

      /*  val gm = GridLayoutManager(this, 2)
        mUserBinding.recycleview.layoutManager= gm */


        mUserViewModel.userList.observe(this, Observer {
            Log.d(TAG,"observe data received  ")
            adapter.setUsersList(it)
        })

        mUserViewModel.erroMessage.observe(this, Observer {
            Log.d(TAG," error "+it)
        })

    }

    override fun onStarted() {
    }

    override fun onError() {
    }

    override fun onDataLoaed() {

    }

}