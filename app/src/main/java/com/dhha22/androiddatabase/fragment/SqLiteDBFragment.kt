package com.dhha22.androiddatabase.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dhha22.androiddatabase.R
import com.dhha22.androiddatabase.log.Logger
import com.dhha22.androiddatabase.util.SQLiteDBManager
import com.dhha22.androiddatabase.view.ListItemView
import com.dhha22.bindadapter.BindAdapter
import kotlinx.android.synthetic.main.fragment_database.*
import rx.Observable
import rx.Single

/**
 * Created by DavidHa on 2017. 11. 3..
 */

class SqLiteDBFragment : Fragment() {
    private lateinit var manager: SQLiteDBManager
    private lateinit var adapter: BindAdapter

    companion object {
        fun getInstance(): SqLiteDBFragment {
            return SqLiteDBFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = BindAdapter(context).addLayout(ListItemView::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_database, container, false)
        manager = SQLiteDBManager(context)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter

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