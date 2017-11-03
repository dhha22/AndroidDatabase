package com.dhha22.androiddatabase.util

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.dhha22.androiddatabase.log.Logger

/**
 * Created by DavidHa on 2017. 11. 3..
 */
class MySQLiteOpenHelper(context: Context, name: String = "AndroidDatabase", version: Int = 1)
    : SQLiteOpenHelper(context, name, null, version) {
    val TABLE_NAME = "SQLiteDBUser"

    // SQLiteOpenHelper 가 최초 실행되었을 때
    override fun onCreate(db: SQLiteDatabase) {
        val sql = "CREATE TABLE $TABLE_NAME (id integer primary key autoincrement, name text, age integer);"
        db.execSQL(sql)
        Logger.v("create SQLiteDB")
    }

    // DB 버전이 업그레이드 되었을 때
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }


}