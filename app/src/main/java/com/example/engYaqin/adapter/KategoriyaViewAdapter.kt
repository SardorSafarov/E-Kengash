package com.example.engYaqin.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.katrip.R
import com.example.katrip.databinding.ItemEngYaqinKategoriyaBinding
import com.example.katrip.databinding.ItemEngYaqinKategoriyaViewBinding
import com.example.log.D
import com.example.network.entity.explore.engYaqin.Arr
import com.example.network.entity.explore.engYaqin.Category


class KategoriyaViewAdapter(private val listener: kategoriyaView,private val context:Context) :
    RecyclerView.Adapter<KategoriyaViewAdapter.ViewHolder>() {

    interface kategoriyaView {
        fun onclickView(type: String)
    }

    private var list: List<Arr> = mutableListOf()


    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ItemEngYaqinKategoriyaViewBinding.bind(itemView)
        fun bind(item: Arr) {
            Glide.with(context).load(item.file_link).into(binding.image)
           binding.apply {
               name.setText(item.name)
               content.setText(item.content)
               locetionName.setText(item.locetion_name)
           }
            itemView.setOnClickListener {

            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_eng_yaqin_kategoriya_view, parent, false))
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
    ) {
        try {
            holder.bind(list[position])
        } catch (e: Exception) {
            D.d(e.message.toString())
        }

    }

    override fun getItemCount(): Int = list.size

    fun setData(list: List<Arr>) {
        this.list = list
        notifyDataSetChanged()
    }
}