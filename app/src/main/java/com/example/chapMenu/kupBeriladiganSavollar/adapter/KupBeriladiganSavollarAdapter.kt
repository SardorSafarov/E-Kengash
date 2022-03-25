package com.example.chapMenu.kupBeriladiganSavollar.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.katrip.R
import com.example.katrip.databinding.ItemKupBeriladiganSavollarBinding
import com.example.log.D
import com.example.network.entity.kupBeriladiganSavollar.javob.FAQ





class KupBeriladiganSavollarAdapter(): RecyclerView.Adapter<KupBeriladiganSavollarAdapter.ViewHolder>() {

    private  var list:List<FAQ> = mutableListOf()


    inner class ViewHolder(item: View): RecyclerView.ViewHolder(item)
    {
        private var t= true
        private val binding= ItemKupBeriladiganSavollarBinding.bind(itemView)
        fun bind(item: FAQ)
        {
            binding.savolText.setText(item.quesation)
            binding.javobText.setText(item.answer)
            itemView.setOnClickListener {
                if(t)
                {
                    binding.icon.setImageResource(R.drawable.ic_kup_savol_item_ic)
                    binding.javobText.visibility = View.VISIBLE
                    t= false
                }
                else{
                    binding.icon.setImageResource(R.drawable.ic_kirish)
                    binding.javobText.visibility = View.GONE
                    t=true
                }
            }
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): KupBeriladiganSavollarAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_kup_beriladigan_savollar,parent,false))
    }

    override fun onBindViewHolder(holder: KupBeriladiganSavollarAdapter.ViewHolder, position: Int) {
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