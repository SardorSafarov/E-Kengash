package com.example.katrip.adapter.asosiy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.katrip.R
import com.example.katrip.databinding.ItemAsosiyTugmalarBinding
import com.example.katrip.recyclerViewItemEntity.AsosiyServislarButtonEntity

class AsosiyServeslarButtonAdapter():RecyclerView.Adapter<AsosiyServeslarButtonAdapter.ViewHolder>() {


     private  var list:List<AsosiyServislarButtonEntity> = listOf()


    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        private val binding=ItemAsosiyTugmalarBinding.bind(itemView)
        fun bind(item:AsosiyServislarButtonEntity)
        {
            when(item.buttonName.size)
            {
                8->{
                    binding.buttonIcon1.setImageResource(item.buttonName[0].icon)
                }
                6->{

                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
       return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_asosiy_tugmalar,parent,false))
    }

    override fun onBindViewHolder(holder: AsosiyServeslarButtonAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setData(list: List<AsosiyServislarButtonEntity>)
    {
        this.list = list
        notifyDataSetChanged()
    }

}