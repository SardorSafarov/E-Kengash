package com.example.katrip.fragmentlar.asosiyy.bildirishnomalar.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.katrip.R
import com.example.katrip.databinding.ItemYangiliklarBinding
import com.example.network.entity.bildirshnoma.Arr


class BildishNomaAdapter(private val listener:onClickListener,private val applicationContext:Context): RecyclerView.Adapter<BildishNomaAdapter.ViewHolder>() {


    private  var list:List<Arr> = listOf()

    interface onClickListener{
        fun onclickListener(item: Arr)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding= ItemYangiliklarBinding.bind(itemView)
        fun bind(item: Arr)
        {
            Glide.with(applicationContext).load(item.image_link).into(binding.image)
            binding.name.setText(item.name)
            binding.content.setText(item.content)
            binding.date.setText(item.date)
            itemView.setOnClickListener {
                listener.onclickListener(item)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_yangiliklar,parent,false))
    }

    override fun onBindViewHolder(holder: BildishNomaAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setData(list: List<Arr>)
    {
        this.list = list
        notifyDataSetChanged()
    }

}