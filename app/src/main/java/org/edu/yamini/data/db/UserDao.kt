package org.edu.yamini.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.edu.yamini.data.db.entities.Users


@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(user : List<Users>) : List<Long>

    @Query("select * from users")
    fun getUsers() : LiveData<Users>

}