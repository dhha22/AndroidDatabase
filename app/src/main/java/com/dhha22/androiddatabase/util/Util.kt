package com.dhha22.androiddatabase.util

import java.util.*

/**
 * Created by DavidHa on 2017. 11. 3..
 */
class Util {
    companion object {
        fun getUserAge() : Int {
            val random = Random()
            return random.nextInt(40) + 10
        }

    }
}