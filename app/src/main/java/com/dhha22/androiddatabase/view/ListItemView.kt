package com.dhha22.androiddatabase.view

import android.content.Context
import com.dhha22.androiddatabase.R
import com.dhha22.androiddatabase.model.User
import com.dhha22.bindadapter.Item
import com.dhha22.bindadapter.ItemView
import kotlinx.android.synthetic.main.list_item.view.*

/**
 * Created by DavidHa on 2017. 11. 3..
 */
class ListItemView(context: Context) : ItemView(context) {
    init {
        setContentView(R.layout.list_item)
        setFullSpan()
    }

    override fun setData(data: Item?) {
        super.setData(data)
        if (data is User) {
            infoTxt.text = StringBuilder("name: ${data.name}, age: ${data.age}")
        }
    }
}