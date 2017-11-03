package com.dhha22.androiddatabase.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dhha22.androiddatabase.Navigator
import com.dhha22.androiddatabase.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by DavidHa on 2017. 11. 3..
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        goSqLiteDB.setOnClickListener { Navigator.goSqLiteDB(this) }
    }
}