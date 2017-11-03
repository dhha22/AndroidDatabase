package com.dhha22.androiddatabase

import android.content.Context
import android.content.Intent
import com.dhha22.androiddatabase.activity.NavigationActivity
import com.dhha22.androiddatabase.fragment.SqLiteDBFragment

/**
 * Created by DavidHa on 2017. 11. 3..
 */
class Navigator {
    companion object {
        fun goSqLiteDB(context: Context) {
            val intent = Intent(context, NavigationActivity::class.java)
            NavigationActivity.fragment = SqLiteDBFragment.getInstance()
            context.startActivity(intent)
        }
    }
}