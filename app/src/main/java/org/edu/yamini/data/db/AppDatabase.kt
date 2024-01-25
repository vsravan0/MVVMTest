package org.edu.yamini.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.edu.yamini.data.db.entities.Users
import java.util.concurrent.locks.Lock

@Database(
    entities = [Users::class],
    version = 1
)
abstract  class AppDatabase : RoomDatabase() {

    abstract fun getuserDao() : UserDao

    companion object {
        private var instance : AppDatabase? = null
        private val Lock = Any()

        operator fun  invoke(context: Context) = instance?: synchronized(Lock){
            instance?.buildDatabase(context).also {
                instance = it
            }
        }

    }

    private fun buildDatabase(context: Context) = Room.databaseBuilder(context.applicationContext,
        AppDatabase::class.java,
        "MyDatabase.db"
    ).build()


}