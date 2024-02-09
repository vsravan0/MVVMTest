package org.edu.yamini.data.db

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import junit.framework.TestCase
import org.edu.yamini.data.db.entities.Users
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class AppDatabaseTest /*: TestCase() */ {

    private lateinit var db  : AppDatabase
    private lateinit var dao  : UserDao


    @Before
    public /*override */ fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        dao = db.getuserDao();
    }

    @Test
    fun checkIsSameUser() {
        val user  = Users("yamini","yamini123","mail","9912326989","www.android.com")
        dao.saveUser(user)
        val userTemp = dao.getSavedUsers().get(0)
        val isSameName = userTemp.name.equals(user.name)
        assertThat(isSameName).isEqualTo(true)
    }

    @Test
    fun checkIsDifferentUser() {
        val user  = Users("yaminii","yamini123","mail","9912326989","www.android.com")
        dao.saveUser(user)
        val user2  = Users("yamini","yamini123","mail","9912326989","www.android.com")
        val userTemp = dao.getSavedUsers().get(0)
        val isSameName = userTemp.name.equals(user2.name)
        assertThat(isSameName).isEqualTo(false)
    }

    @Test
    fun dataCheck() {

        val user1  = Users("yamini_1","yamini123","mail","9912326989","www.android.com")
        dao.saveUser(user1)
        val userList1 = dao.getSavedUsers()
        val user2  = Users("yamini_2","yamini123","mail","9912326989","www.android.com")
        dao.saveUser(user2)
        val userList2 = dao.getSavedUsers()


    }

    @After
    fun closeDb() {
        db.close()
    }

}