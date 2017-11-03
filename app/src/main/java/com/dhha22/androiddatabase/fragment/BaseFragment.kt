package com.dhha22.androiddatabase.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dhha22.androiddatabase.R
import com.dhha22.androiddatabase.view.ListItemView
import com.dhha22.bindadapter.BindAdapter
import kotlinx.android.synthetic.main.fragment_database.*

/**
 * Created by DavidHa on 2017. 11. 3..
 */
open class BaseFragment : Fragment(){
    protected lateinit var adapter : BindAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = BindAdapter(context).addLayout(ListItemView::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_database, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
    }
}