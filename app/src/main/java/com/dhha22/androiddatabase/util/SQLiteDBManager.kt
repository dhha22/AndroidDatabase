package com.dhha22.androiddatabase.util

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.dhha22.androiddatabase.model.User
import java.util.ArrayList

/**
 * Created by DavidHa on 2017. 11. 3..
 */
class SQLiteDBManager(context: Context) {
    private val openHelper: MySQLiteOpenHelper = MySQLiteOpenHelper(context)
    private val db: SQLiteDatabase

    init {
        db = openHelper.writableDatabase
    }

    fun insertUserName(name: String) {
        val values = ContentValues()
        values.put("name", name)
        values.put("age", Util.getUserAge())
        db.insert(openHelper.TABLE_NAME, null, values)
    }

    fun updateUserName(user: User) {
        val values = ContentValues()
        values.put("name", user.name)
        values.put("age", user.age)
        db.update(openHelper.TABLE_NAME, values, "id=?", arrayOf(user.id.toString()))
    }

    fun deleteUser(id: Int) {
        db.delete(openHelper.TABLE_NAME, "id=?", arrayOf(id.toString()))
    }


    fun selectAll(): ArrayList<User> {
        val userList = ArrayList<User>()
        val cursor = db.query(openHelper.TABLE_NAME, null, null, null, null, null, null, null)
        while (cursor.moveToNext()) {
            val id: Int = cursor.getInt(cursor.getColumnIndex("id"))
            val name = cursor.getString(cursor.getColumnIndex("name"))
            val age = cursor.getInt(cursor.getColumnIndex("age"))
            userList.add(User(id, name, age))
        }
        cursor.close()
        return userList
    }
}