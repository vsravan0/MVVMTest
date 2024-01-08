package org.edu.yamini.viewmodel

interface AuthListener {

    fun onStarted()
    fun onSuccess()
    fun onFailure(message : String )
}