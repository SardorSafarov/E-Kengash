package com.example.chapMenu.valyutaKurslari.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.katrip.R
import com.example.katrip.databinding.ItemValyutaBinding
import com.example.log.D
import com.example.network.entity.valyuta.ValyutaEntityItem
import java.math.RoundingMode
import java.text.DecimalFormat

class ValyutaKurslariAdapter():RecyclerView.Adapter<ValyutaKurslariAdapter.ViewHolder>() {

  private  var list:List<ValyutaEntityItem> = mutableListOf()


    inner class ViewHolder(item: View):RecyclerView.ViewHolder(item)
    {
        private val binding= ItemValyutaBinding.bind(itemView)
        fun bind(item:ValyutaEntityItem)
        {
            when(adapterPosition)
            {
                0->{
                    binding.davlatBayrog.setImageResource(R.drawable.usa)
                    binding.valyutaRamziyKodi.setText("1 " + item.Ccy)
                    binding.valyutaNomi.setText(item.CcyNm_UZ)
                    binding.valyutaMbDagi.setText(item.Rate)
                    val df = DecimalFormat("#.##")
                    df.roundingMode = RoundingMode.CEILING
                    binding.valyutaSotibOlish.setText(df.format(item.Rate.toDouble() - 1000).toString())
                    binding.valyutaSotish.setText(df.format(item.Rate.toDouble() + 2000).toString())
                }
                1->{
                    binding.davlatBayrog.setImageResource(R.drawable.euro)
                    binding.valyutaRamziyKodi.setText("1 " + item.Ccy)
                    binding.valyutaNomi.setText(item.CcyNm_UZ)
                    binding.valyutaMbDagi.setText(item.Rate)
                    val df = DecimalFormat("#.##")
                    df.roundingMode = RoundingMode.CEILING
                    binding.valyutaSotibOlish.setText(df.format(item.Rate.toDouble() - 1000).toString())
                    binding.valyutaSotish.setText(df.format(item.Rate.toDouble() + 3000).toString())
                }
                2->{
                    binding.davlatBayrog.setImageResource(R.drawable.russia)
                    binding.valyutaRamziyKodi.setText("1 " + item.Ccy)
                    binding.valyutaNomi.setText(item.CcyNm_UZ)
                    binding.valyutaMbDagi.setText(item.Rate)
                    val df = DecimalFormat("#.##")
                    df.roundingMode = RoundingMode.CEILING
                    binding.valyutaSotibOlish.setText(df.format(item.Rate.toDouble() - 1).toString())
                    binding.valyutaSotish.setText(df.format(item.Rate.toDouble() + 7).toString())
                }
                3->{
                    binding.davlatBayrog.setImageResource(R.drawable.gbp)
                    binding.valyutaRamziyKodi.setText("1 " + item.Ccy)
                    binding.valyutaNomi.setText(item.CcyNm_UZ)
                    binding.valyutaMbDagi.setText(item.Rate)
                    val df = DecimalFormat("#.##")
                    df.roundingMode = RoundingMode.CEILING
                    binding.valyutaSotibOlish.setText(df.format(item.Rate.toDouble() - 1000).toString())
                    binding.valyutaSotish.setText(df.format(item.Rate.toDouble() + 1000).toString())
                }
                4->{
                    binding.davlatBayrog.setImageResource(R.drawable.jpy)
                    binding.valyutaRamziyKodi.setText("1 " + item.Ccy)
                    binding.valyutaNomi.setText(item.CcyNm_UZ)
                    binding.valyutaMbDagi.setText(item.Rate)
                    val df = DecimalFormat("#.##")
                    df.roundingMode = RoundingMode.CEILING
                    binding.valyutaSotibOlish.setText(df.format(item.Rate.toDouble() - 10).toString())
                    binding.valyutaSotish.setText(df.format(item.Rate.toDouble() + 20).toString())
                }
                5->{
                    binding.davlatBayrog.setImageResource(R.drawable.chf)
                    binding.valyutaRamziyKodi.setText("1 CHF")
                    binding.valyutaNomi.setText("Shveytsariya franki")
                    binding.valyutaMbDagi.setText(item.Rate)
                    val df = DecimalFormat("#.##")
                    df.roundingMode = RoundingMode.CEILING
                    binding.valyutaSotibOlish.setText(df.format(item.Rate.toDouble() - 1000).toString())
                    binding.valyutaSotish.setText(df.format(item.Rate.toDouble() + 4000).toString())
                }
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