package com.example.katrip.servislar.turarJoylar.adapter.turarJoyRuyxati

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.katrip.R
import com.example.katrip.databinding.ItemTurarJoyBinding
import com.example.log.D
import com.example.network.entity.turarJoy.izlash.Arr


class IzlanganTurarJoyAdapter(private val listener: izlanganTurarJoySetOnClickListener): RecyclerView.Adapter<IzlanganTurarJoyAdapter.ViewHolder>() {


    private  var list:List<Arr> = listOf()
    private var shaxar = ""
    interface izlanganTurarJoySetOnClickListener{
        fun izlanganTurarJoySetOnClickListener(id: Int)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding= ItemTurarJoyBinding.bind(itemView)
        fun bind(item: Arr, shaxar: String)
        {
            binding.locetionName.text = shaxar
            binding.apply {
                name.setText(item.city)
                reting.setText(item.reting)
                retingName.setText(item.reting_name)

            }
            itemView.setOnClickListener {
                listener.izlanganTurarJoySetOnClickListener(item.id)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_turar_joy,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        try {
            holder.bind(list[position],shaxar)
        }catch (e:Exception){
            D.d("IzlanganTurarJoyAdapter onBindViewHolder fun")
        }

    }

    override fun getItemCount(): Int = list.size

    fun setData(list: List<Arr>, shaxar: String)
    {
        this.shaxar = shaxar
        this.list = list
        notifyDataSetChanged()

    }

}