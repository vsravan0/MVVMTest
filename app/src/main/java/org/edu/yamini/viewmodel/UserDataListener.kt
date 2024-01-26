package org.edu.yamini.viewmodel

import androidx.lifecycle.LiveData
import org.edu.yamini.data.db.entities.Users

interface UserDataListener {


    fun onStarted()

    fun onFailure(data : String)

    fun onSuccess(data : LiveData<List<Users>>)
}