package com.example.servislar.taxi.adapter.haydovchiIzlash

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.katrip.R
import com.example.katrip.databinding.ItemTaxiHaydovchiBinding
import com.example.log.D
import com.example.network.entity.taxi.haydovchi.javob.Haydovchi


class HaydovchiIzlashAdapter(private val listener: kategoriyaView, private val context: Context) :
    RecyclerView.Adapter<HaydovchiIzlashAdapter.ViewHolder>() {

    interface kategoriyaView {
        fun onclickView(type: String)
    }

    private var list: List<Haydovchi> = mutableListOf()


    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ItemTaxiHaydovchiBinding.bind(itemView)
        fun bind(item: Haydovchi) {
            D.d(item.toString())
            Glide.with(context).load("https://yulda.uz/storage/users/March2022/avatar_1647669227.png").into(binding.image)
            D.d(item.price.toString())
            D.d(item.seats.toString())
            D.d(item.distance.toString())
            binding.apply {
                price.setText(item.price.toString())
                name.setText(item.driver.name)
                seats.setText(item.seats.toString())
//                seats.setText(seats.toString())
//                distance.setText(item.distance.toString())
//                name.setText(item.driver.name.toString())
//                manzillar.setText(item.from_address+"-"+item.to_address)
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
            .inflate(R.layout.item_taxi_haydovchi, parent, false))
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

    fun setData(list: List<Haydovchi>) {
        this.list = list
        notifyDataSetChanged()
    }
}