package com.example.chapMenu.kupBeriladiganSavollar.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ekengash.R
import com.example.ekengash.databinding.ItemSelectButtonBinding
import com.example.log.D
import com.example.network.netWorkEndtity.kupBeriladiganSavollar.javob.FAQTYPE
import com.example.network.netWorkEndtity.valyuta.ValyutaEntityItem




class KupBeriladiganSavollarKategoriyaAdapter(): RecyclerView.Adapter<KupBeriladiganSavollarKategoriyaAdapter.ViewHolder>() {

  private  var list:List<FAQTYPE> = mutableListOf()


    inner class ViewHolder(item: View): RecyclerView.ViewHolder(item)
    {
        private val binding= ItemSelectButtonBinding.bind(itemView)
        fun bind(item: FAQTYPE)
        {
            binding.btnText.setText(item.type)
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): KupBeriladiganSavollarKategoriyaAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_select_button,parent,false))
    }

    override fun onBindViewHolder(holder: KupBeriladiganSavollarKategoriyaAdapter.ViewHolder, position: Int) {
        try {
            holder.bind(list[position])
        }catch (e:Exception)
        {
            D.d(e.message.toString())
        }

    }

    override fun getItemCount(): Int  = list.size

    fun setData(list:List<FAQTYPE>){
        this.list = list
        notifyDataSetChanged()
    }
}