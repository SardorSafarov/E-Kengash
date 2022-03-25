package com.example.katrip.fragmentlar.asosiyy.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.katrip.R
import com.example.katrip.databinding.ItemAsosiyLayfhaklarBinding
import com.example.log.D
import com.example.network.entity.takliflarLayfxaklar.javob.Arr

class TakliflarLayfxaklarAdapter(private val listener:onClickListener,private val applicationContext:Context): RecyclerView.Adapter<TakliflarLayfxaklarAdapter.ViewHolder>() {

    private  var list:List<Arr> = mutableListOf()

    interface onClickListener{
        fun onClickListener(item: Arr)
    }
    inner class ViewHolder(item: View): RecyclerView.ViewHolder(item)
    {
        private val binding= ItemAsosiyLayfhaklarBinding.bind(itemView)
        fun bind(item: Arr)
        {
            binding.text.setText(item.name)
            Glide.with(applicationContext).load(item.image_link).into(binding.image)
            itemView.setOnClickListener {
               listener.onClickListener(item)
            }
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TakliflarLayfxaklarAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_asosiy_layfhaklar,parent,false))
    }

    override fun onBindViewHolder(holder: TakliflarLayfxaklarAdapter.ViewHolder, position: Int) {
        try {
            holder.bind(list[position])
        }catch (e:Exception)
        {
            D.d(e.message.toString())
        }

    }

    override fun getItemCount(): Int  = list.size

    fun setData(list:List<Arr>){
        this.list = list
        notifyDataSetChanged()
    }
}