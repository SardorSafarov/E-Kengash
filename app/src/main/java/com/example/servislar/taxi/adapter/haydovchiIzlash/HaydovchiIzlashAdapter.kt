package com.example.servislar.taxi.adapter.haydovchiIzlash

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.katrip.R
import com.example.katrip.databinding.ItemTaxiHaydovchiBinding
import com.example.log.D
import com.example.network.entity.taxi.haydovchi.javob.Haydovchi


class HaydovchiIzlashAdapter(private val listener: haydovchiIzlashListener, private val context: Context) :
    RecyclerView.Adapter<HaydovchiIzlashAdapter.ViewHolder>() {

    interface haydovchiIzlashListener {
        fun onclickView(
            price: String,
            driver: String,
            seats: String,
            duration: String,
            departure_time: String,
            qayerdan: String,
            mashinaRanggi: String,
            s: String,
            s1: String
        )

    }

    private var list: List<Haydovchi> = mutableListOf()
    private var qayerdan:String=""
    private var qayerga:String=""
    private var vaqt =""

    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ItemTaxiHaydovchiBinding.bind(itemView)
        var t=1
        fun bind(item: Haydovchi, qayerdan: String, qayerga: String, vaqt: String) {
            Glide.with(context).load("https://yulda.uz/storage/${item.driver.avatar}").into(binding.image)
            binding.apply {
                price.setText(item.price.toString()+" UZS")
                name.setText(item.driver.name)
                seats.setText(item.seats.toString())
                duration.setText((item.duration.toInt() / 3600).toString())
                distance.setText((item.distance/1000).toString()+" km")
                departureTime.setText(item.departure_time.toString())
                manzillar.setText(qayerdan+"\n"+qayerga)
                mashinaRanggi.setText("Chevrolet Nexia | Белый")
                borishKuni.setText(vaqt)
            }
            when(t)
            {
                1->{
                    binding.mashinaRanggi.setText("Chevrolet Nexia | Белый")
                    t=2
                }
                2->{
                    binding.mashinaRanggi.setText("Chevrolet Lacetti | Белый")
                    t=1
                }
            }
            itemView.setOnClickListener {
                listener.onclickView(

                    item.price.toString(),
                    item.driver.name.toString(),
                    item.seats.toString(),
                    (item.duration.toInt() / 3600).toString(),
                    item.departure_time.toString(),
                    (qayerdan+"\n"+qayerga).toString(),
                    binding.mashinaRanggi.text.toString(),
                    ((item.distance/1000).toString()+" km"),
                    "https://yulda.uz/storage/${item.driver.avatar}"
                )
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_taxi_haydovchi, parent, false))
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
    ) {
        try {
            holder.bind(list[position],qayerdan,qayerga,vaqt)
        } catch (e: Exception) {
            D.d(e.message.toString())
        }

    }

    override fun getItemCount(): Int = list.size

    fun setData(list: List<Haydovchi>, qayerdan: String, qayerga: String, vaqt: String) {
        this.list = list
        notifyDataSetChanged()
        this.qayerdan=qayerdan
        this.qayerga=qayerga
        this.vaqt = vaqt
    }
}