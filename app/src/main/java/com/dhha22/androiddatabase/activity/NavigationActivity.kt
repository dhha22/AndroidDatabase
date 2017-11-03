package com.dhha22.androiddatabase.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.dhha22.androiddatabase.R

/**
 * Created by DavidHa on 2017. 11. 3..
 */
class NavigationActivity : AppCompatActivity() {
    companion object {
        var fragment: Fragment? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(fragment != null){
            setContentView(R.layout.activity_navigation)
            supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
        }
        fragment = null
    }

}