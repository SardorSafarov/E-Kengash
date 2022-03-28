package com.example.servislar.turarJoylar.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.katrip.R
import com.example.katrip.databinding.ItemTurarJoyBinding
import com.example.log.D
import com.example.network.entity.turarJoy.izlash.Arr


class IzlanganTurarJoyAdapter(private val listener:izlanganTurarJoySetOnClickListener): RecyclerView.Adapter<IzlanganTurarJoyAdapter.ViewHolder>() {


    private  var list:List<Arr> = listOf()

    interface izlanganTurarJoySetOnClickListener{
        fun izlanganTurarJoySetOnClickListener(id: Int)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding= ItemTurarJoyBinding.bind(itemView)
        fun bind(item: Arr)
        {
            binding.apply {
                name.setText(item.city)
                reting.setText(item.reting)
                retingName.setText(item.reting_name)
                locetionName.setText(item.category)
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
            holder.bind(list[position])
        }catch (e:Exception){
            D.d("IzlanganTurarJoyAdapter onBindViewHolder fun")
        }

    }

    override fun getItemCount(): Int = list.size

    fun setData(list: List<Arr>)
    {
        this.list = list
        notifyDataSetChanged()
    }

}