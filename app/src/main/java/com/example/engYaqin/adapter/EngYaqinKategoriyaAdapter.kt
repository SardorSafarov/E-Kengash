package com.example.engYaqin.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.katrip.R
import com.example.katrip.databinding.ItemEngYaqinKategoriyaBinding
import com.example.log.D
import com.example.network.entity.explore.engYaqin.Category


class EngYaqinKategoriyaAdapter(private val listener: kategoriyaBtn) :
    RecyclerView.Adapter<EngYaqinKategoriyaAdapter.ViewHolder>() {

    interface kategoriyaBtn {
        fun onclick(type: Int)
    }

    private var list: List<Category> = mutableListOf()
    var column_index = 0


    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ItemEngYaqinKategoriyaBinding.bind(itemView)
        fun bind(item: Category) {
            binding.txt.setText(item.name)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_eng_yaqin_kategoriya, parent, false))
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
    ) {
        try {

            holder.bind(list[position])
            holder.itemView.setOnClickListener({
               listener.onclick(list[position].id)
                column_index = position
                notifyDataSetChanged()
            })
            if (column_index === position) {
                holder.binding.txt.setTextColor(Color.parseColor("#ffffff"))
                holder.binding.card.setBackgroundColor(Color.parseColor("#228FFF"))

            } else {
                holder.binding.txt.setTextColor(Color.parseColor("#228FFF"))
                holder.binding.card.setBackgroundColor(Color.parseColor("#ffffff"))

            }
        } catch (e: Exception) {
            D.d(e.message.toString())
        }

    }

    override fun getItemCount(): Int = list.size

    fun setData(list: List<Category>) {
        this.list = list
        notifyDataSetChanged()
    }
}