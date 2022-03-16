package com.example.chapMenu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ekengash.R
import com.example.ekengash.databinding.ItemValyutaBinding
import com.example.log.D
import com.example.network.netWorkEndtity.valyuta.ValyutaEntityItem
import java.math.RoundingMode
import java.text.DecimalFormat

class ValyutaKurslariAdapter():RecyclerView.Adapter<ValyutaKurslariAdapter.ViewHolder>() {

    var list:List<ValyutaEntityItem> = mutableListOf()


    inner class ViewHolder(item: View):RecyclerView.ViewHolder(item)
    {
        private val binding= ItemValyutaBinding.bind(itemView)
        fun bind(item:ValyutaEntityItem)
        {
            when(adapterPosition)
            {
                0->{binding.davlatBayrog.setImageResource(R.drawable.usa)}
                1->{binding.davlatBayrog.setImageResource(R.drawable.euro)}
                2->{binding.davlatBayrog.setImageResource(R.drawable.russia)}
                3->{binding.davlatBayrog.setImageResource(R.drawable.gbp)}
                4->{binding.davlatBayrog.setImageResource(R.drawable.jpy)}
                5->{
                    binding.davlatBayrog.setImageResource(R.drawable.chf)
                }
            }
            if(adapterPosition!=5) {
                binding.valyutaRamziyKodi.setText("1 " + item.Ccy)
                binding.valyutaNomi.setText(item.CcyNm_UZ)
                binding.valyutaMbDagi.setText(item.Rate)
                val df = DecimalFormat("#.##")
                df.roundingMode = RoundingMode.CEILING
                binding.valyutaSotibOlish.setText(df.format(item.Rate.toDouble() - 90).toString())
                binding.valyutaSotish.setText(df.format(item.Rate.toDouble() + 250).toString())
            }else
            {
                binding.valyutaRamziyKodi.setText("1 CHF")
                binding.valyutaNomi.setText("Shveytsariya franki")
                binding.valyutaMbDagi.setText(item.Rate)
                val df = DecimalFormat("#.##")
                df.roundingMode = RoundingMode.CEILING
                binding.valyutaSotibOlish.setText(df.format(item.Rate.toDouble() - 90).toString())
                binding.valyutaSotish.setText(df.format(item.Rate.toDouble() + 250).toString())
            }
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ValyutaKurslariAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_valyuta,parent,false))
    }

    override fun onBindViewHolder(holder: ValyutaKurslariAdapter.ViewHolder, position: Int) {
        try {
            holder.bind(list[position])
        }catch (e:Exception)
        {
            D.d(e.message.toString())
        }

    }

    override fun getItemCount(): Int  = 6

    fun setData(list:List<ValyutaEntityItem>){
        this.list = list
        notifyDataSetChanged()
    }
}