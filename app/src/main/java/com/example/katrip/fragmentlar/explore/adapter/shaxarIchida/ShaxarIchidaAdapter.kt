package com.example.katrip.fragmentlar.explore.adapter.shaxarIchida

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.katrip.R
import com.example.katrip.databinding.ItemExploreShaxarBinding
import com.example.katrip.databinding.ItemShaxarIchidaBinding
import com.example.log.D
import com.example.network.entity.explore.shaxarichi.Arr


class ShaxarIchidaAdapter(private val listener: onClickListener, var applicationContext: Context) :
    RecyclerView.Adapter<ShaxarIchidaAdapter.ViewHolder>() {

    private var list: MutableList<Arr> = mutableListOf()

    interface onClickListener {
        fun shaxarIchidaOnClickListener()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemShaxarIchidaBinding.bind(itemView)

        fun bind(item: Arr) {
            D.d(item.toString())
            Glide.with(applicationContext).load(item.file_link).into(binding.image)
          binding.apply {
              name.setText(item.name)
              price.setText(item.price.toString())
              delPrice.setText(item.del_price.toString())
              commentCount.setText(item.comment_count.toString())
              content.setText(item.content)
              locetionName.setText(item.locetion_name)

          }
            itemView.setOnClickListener {
                listener.shaxarIchidaOnClickListener()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_shaxar_ichida, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        try {
            holder.bind(list[position])
        } catch (e: Exception) {
            D.d("${e.message} ShaxarIchidaAdapter  onBindViewHolder")
        }

    }

    override fun getItemCount(): Int = list.size

    fun getData(survey: List<Arr>) {
        this.list = survey as MutableList<Arr>
        notifyDataSetChanged()
    }

}