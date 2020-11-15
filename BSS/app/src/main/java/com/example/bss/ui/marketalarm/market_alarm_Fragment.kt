/*
package com.example.bss.ui.marketalarm

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import com.example.bss.R
import kotlinx.android.synthetic.main.fragment_store_information.*

class market_alarm_Fragment : Fragment() {

    private lateinit var viewModel: MarketAlarmViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root =  inflater.inflate(R.layout.fragment_store_information, container, false)

        val listView = root.findViewById<ListView>(R.id.listview)

//        어답터 설정
        listView.adapter = MyCustomAdapter(this)

//        Item click listener
        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectItem = parent.getItemAtPosition(position) as String
            selectName.text = selectItem
            //Toast.makeText(this, selectItem, Toast.LENGTH_SHORT).show()
        }
        return root
    }

    private class MyCustomAdapter(context: market_alarm_Fragment) : BaseAdapter() {
        private val mContext: Context = context

        //데이터 어레이
        private val names = arrayListOf<String>(
            "이순신", "강감찬", "연개소문", "김유신", "을지문덕"
        )

        override fun getCount(): Int {
            return names.size
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getItem(position: Int): Any {
            val selectItem = names.get(position)
            return selectItem
        }

        override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val rowMain = layoutInflater.inflate(R.layout.coupon_row, viewGroup, false)

            val nameTextView = rowMain.findViewById<TextView>(R.id.name_textview)
            nameTextView.text = names.get(position)
            val positionTextView = rowMain.findViewById<TextView>(R.id.position_textview)
            positionTextView.text = "순서: " + position

            return rowMain
        }
    }
}
 */