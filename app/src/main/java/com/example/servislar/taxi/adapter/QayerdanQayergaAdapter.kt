package com.example.servislar.taxi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.katrip.R
import com.example.katrip.databinding.ItemEngYaqinKategoriyaViewBinding
import com.example.katrip.databinding.ItemQayerdanQayergaBinding
import com.example.log.D
import com.example.network.entity.explore.engYaqin.Arr



class QayerdanQayergaAdapter(private val listener: kategoriyaView,private val context: Context) :
    RecyclerView.Adapter<QayerdanQayergaAdapter.ViewHolder>() {

    interface kategoriyaView {
        fun onclickView(type: String)
    }

    private var list: List<Arr> = mutableListOf()


    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ItemQayerdanQayergaBinding.bind(itemView)
        fun bind(item: Arr) {
            
            itemView.setOnClickListener {

            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_qayerdan_qayerga, parent, false))
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