package org.edu.yamini.view

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import org.edu.yamini.data.db.AppDatabase
import org.edu.yamini.data.db.UserDao
import org.edu.yamini.data.db.entities.Users
import org.edu.yamini.data.network.MyApi
import org.edu.yamini.data.repositories.UserRepository
import org.edu.yamini.databinding.LayoutUsersBinding
import org.edu.yamini.viewmodel.UserAdapter
import org.edu.yamini.viewmodel.UserDataListener
import org.edu.yamini.viewmodel.UserViewModel

class ActivityUsers : ComponentActivity() , UserDataListener{

    private val TAG = "ActivityUsers";
    private lateinit var mUserBinding : LayoutUsersBinding
    private lateinit var mUserViewModel : UserViewModel
    val adapter = UserAdapter()
    lateinit var db : AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        db = AppDatabase(this)
        val api = MyApi()
        val repository = UserRepository(api, db );
        val factory  = UserViewModelFactory(repository)


        mUserBinding = LayoutUsersBinding.inflate(layoutInflater)
        setContentView(mUserBinding.root)
        mUserViewModel = ViewModelProvider(this, factory).get(UserViewModel::class.java)
        mUserBinding.userviewmodel = mUserViewModel
        mUserViewModel.userDataListener = this
        mUserBinding.recycleview.adapter = adapter

       val lm = LinearLayoutManager(this)
        lm.orientation = LinearLayoutManager.VERTICAL
        mUserBinding.recycleview.layoutManager = lm
      /*  val gm = GridLayoutManager(this, 2)
        mUserBinding.recycleview.layoutManager= gm */
    }

    override fun onStarted() {
        Log.d(TAG,"onStarted");
    }

    override fun onFailure(data: String) {
        Log.d(TAG,"onFailure "+data);
    }

    override fun onSuccess(data: LiveData<List<Users>>) {
        Log.d(TAG,"onSuccess "+data);
        data.observe(this, Observer {
            Log.d(TAG,"onSuccess loaded -> "+data);
            adapter.setUsersList(it)
            Log.d(TAG,"onSuccess  Database insert Data");
         //  db.getuserDao().upsert(it)

        })
    }

    override fun onSuccess(data: List<Users>) {
        Log.d(TAG,"onSuccess coroutine " + data);
        val indexes = db.getuserDao().upsert(data)
        Log.d(TAG,"onSuccess Db Data saved  " + indexes);
        //updateList(data)

        runOnUiThread{
                     adapter.setUsersList(data)
                 }
    }

    private fun updateList(list : List<Users>) {
        Log.d(TAG,"updateList  started ");

        runOnUiThread{
            Log.d(TAG,"updateList inside Ui Thread start ");
            adapter.setUsersList(list)
            Log.d(TAG,"updateList inside Ui Thread end ");
        }
        Log.d(TAG,"updateList outside Ui Thread end ");
    }

}