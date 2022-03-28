package com.example.katrip.fragmentlar.explore.adapter.shaxar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.katrip.R
import com.example.katrip.databinding.ItemExploreShaxarBinding
import com.example.log.D
import com.example.network.entity.explore.shaxarlar.javob.Arr

class ExploreAdapter(private val listener: onClickListener, var applicationContext: Context) :
    RecyclerView.Adapter<ExploreAdapter.ViewHolder>() {

    private var list: MutableList<Arr> = mutableListOf()

    interface onClickListener {
        fun shaxarOnclick(shaxarId: Int, name: String)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemExploreShaxarBinding.bind(itemView)

        fun bind(item: Arr) {
            Glide.with(applicationContext).load(item.img_link).into(binding.surovNomaImage)
            binding.surovNomaText.setText(item.name)
            itemView.setOnClickListener {
                listener.shaxarOnclick(item.id, item.name)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_explore_shaxar, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        try {
            holder.bind(list[position])
        } catch (e: Exception) {
            D.d("${e.message}")
        }

    }

    override fun getItemCount(): Int = list.size

    fun getData(survey: List<Arr>) {
        this.list = survey as MutableList<Arr>
        notifyDataSetChanged()
    }

}