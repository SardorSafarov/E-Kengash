package com.example.kirsh.surovnoma.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ekengash.R
import com.example.ekengash.databinding.ItemSurovnomaBinding

class SurovNomaAdapter(private val listener:onClickListener) : RecyclerView.Adapter<SurovNomaAdapter.ViewHolder>() {

    private val list:MutableList<String> = mutableListOf()

    interface onClickListener{
        fun surovNomaOnclick()
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        private val binding = ItemSurovnomaBinding.bind(itemView)
        fun bind(list: MutableList<String>) {
            itemView.setOnClickListener {
                listener.surovNomaOnclick()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(LayoutInflater.from(parent.context).inflate( R.layout.item_surovnoma,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.bind(list)
    }

    override fun getItemCount(): Int =list.size



}