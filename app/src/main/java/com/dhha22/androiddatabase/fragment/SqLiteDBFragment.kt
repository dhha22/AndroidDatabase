package com.dhha22.androiddatabase.fragment

import android.os.Bundle
import android.view.View
import com.dhha22.androiddatabase.log.Logger
import com.dhha22.androiddatabase.util.SQLiteDBManager
import kotlinx.android.synthetic.main.fragment_database.*
import rx.Observable
import rx.Single

/**
 * Created by DavidHa on 2017. 11. 3..
 */

class SqLiteDBFragment : BaseFragment() {
    private lateinit var manager: SQLiteDBManager

    companion object {
        fun getInstance(): SqLiteDBFragment {
            return SqLiteDBFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        manager = SQLiteDBManager(context)
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        insertBtn.setOnClickListener {
            val name = inputName.text.trim().toString()
            inputName.text = null
            Single.just(manager.insertUserName(name)).subscribe({ refreshData() }, { Logger.e(it) })
        }

        refreshData()
    }

    private fun refreshData() {
        adapter.clearItem()
        Observable.from(manager.selectAll())
                .doAfterTerminate { adapter.notifyData() }
                .subscribe({ adapter.addItem(it) }, { Logger.e(it) })
    }

}