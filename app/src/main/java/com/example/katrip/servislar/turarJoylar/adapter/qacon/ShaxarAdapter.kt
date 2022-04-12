package com.example.katrip.servislar.turarJoylar.adapter.qacon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.katrip.R
import com.example.katrip.databinding.ItemQayerdanQayergaBinding
import com.example.log.D


class ShaxarAdapter(private val listener:ShaxarListener): RecyclerView.Adapter<ShaxarAdapter.ViewHolder>() {


    private  var list:List<String> = listOf()

    interface ShaxarListener{
        fun shaxarListener(id: String)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding= ItemQayerdanQayergaBinding.bind(itemView)
        fun bind(item: String)
        {
            binding.shaxarNomi.setText(item)
            itemView.setOnClickListener {
                listener.shaxarListener(item)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_qayerdan_qayerga,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        try {
            holder.bind(list[position])
        }catch (e:Exception){
            D.d("IzlanganTurarJoyAdapter onBindViewHolder fun")
        }

    }

    override fun getItemCount(): Int = list.size

    fun setData(list: List<String>)
    {
        this.list = list
        notifyDataSetChanged()
    }

}