package com.example.ekengash.adapter.spinner

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.ekengash.R
import com.example.ekengash.entity.SpinnerEntity
import kotlinx.android.synthetic.main.item_chat_top_spinner.view.*

class ChatSpinnerAdapter(context: Context, list: List<SpinnerEntity>):ArrayAdapter<SpinnerEntity>(context,0,list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    private fun initView(position: Int, convertView: View?, parent: ViewGroup):View{
        val item=getItem(position)
        val view = LayoutInflater.from(context).inflate(R.layout.item_chat_top_spinner,parent,false)
        view.chat_top_spinner_image.setImageResource(item!!.image)
        view.chat_top_spinner_text.setText(item!!.text)
        return view
    }
}