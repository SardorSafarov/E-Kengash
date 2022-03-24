package com.example.ekengash.fragmentlar.asosiyy.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ekengash.R
import com.example.ekengash.databinding.ItemAsosiyLayfhaklarBinding
import com.example.ekengash.databinding.ItemKupBeriladiganSavollarBinding
import com.example.log.D
import com.example.network.endtity.kupBeriladiganSavollar.javob.FAQ

class TakliflarLayfxaklarAdapter(): RecyclerView.Adapter<TakliflarLayfxaklarAdapter.ViewHolder>() {

    private  var list:List<FAQ> = mutableListOf()


    inner class ViewHolder(item: View): RecyclerView.ViewHolder(item)
    {
        private val binding= ItemAsosiyLayfhaklarBinding.bind(itemView)
        fun bind(item: FAQ)
        {

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

    fun setData(list:List<FAQ>){
        this.list = list
        notifyDataSetChanged()
    }
}