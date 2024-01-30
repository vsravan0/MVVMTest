package org.edu.yamini

import android.app.Application
import android.util.Log
import org.edu.yamini.data.db.AppDatabase
import org.edu.yamini.data.network.MyApi
import org.edu.yamini.data.repositories.UserRepository
import org.edu.yamini.view.UserViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MvvmApplication : Application(), KodeinAware {

    override val kodein  = Kodein.lazy {

        import(androidXModule(this@MvvmApplication))

        bind() from singleton { MyApi() }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { UserRepository(instance(), instance()) }
        bind() from provider { UserViewModelFactory (instance())}


        /*

          db = AppDatabase(this)
        val api = MyApi()
        val repository = UserRepository(api, db );
        val factory  = UserViewModelFactory(repository)
         */

    }

    override fun onCreate() {
        super.onCreate()
        Log.d("MvvmApplication","MvvmApplication onCreate")
    }


}