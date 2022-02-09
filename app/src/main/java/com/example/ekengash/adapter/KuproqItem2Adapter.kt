package com.example.ekengash.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ekengash.R
import com.example.ekengash.databinding.ItemKuproq1Binding
import com.example.ekengash.databinding.ItemKuproq2Binding
import com.example.ekengash.entity.KuproqItemEntitit

class KuproqItem2Adapter(private var listener: OnClickLister) :
    RecyclerView.Adapter<KuproqItem2Adapter.ViewHolder>() {

    interface OnClickLister {
        fun onClickListener(userName: String)
    }

    private var list: List<KuproqItemEntitit> = mutableListOf()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemKuproq2Binding.bind(itemView)
        fun bind(item: KuproqItemEntitit) {
            binding.icon.setImageResource(item.icon)
            binding.textView5.text = item.text
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): KuproqItem2Adapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_kuproq_2, parent, false)
        )
    }

    override fun onBindViewHolder(holder: KuproqItem2Adapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setData(list: List<KuproqItemEntitit>) {
        this.list = list
        notifyDataSetChanged()
    }
}