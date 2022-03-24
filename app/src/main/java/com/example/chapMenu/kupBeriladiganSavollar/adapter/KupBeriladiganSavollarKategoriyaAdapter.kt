package com.example.chapMenu.kupBeriladiganSavollar.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.katrip.R
import com.example.katrip.databinding.ItemSelectButtonBinding
import com.example.log.D
import com.example.network.endtity.kupBeriladiganSavollar.javob.FAQTYPE


class KupBeriladiganSavollarKategoriyaAdapter(private val listener: savolKategoriyaBtn) :
    RecyclerView.Adapter<KupBeriladiganSavollarKategoriyaAdapter.ViewHolder>() {

    interface savolKategoriyaBtn {
        fun onclick(type: String)
    }

    private var list: List<FAQTYPE> = mutableListOf()
    var column_index = 0


    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ItemSelectButtonBinding.bind(itemView)
        fun bind(item: FAQTYPE) {
            binding.btnText.setText(item.type)


        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): KupBeriladiganSavollarKategoriyaAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_select_button, parent, false))
    }

    override fun onBindViewHolder(
        holder: KupBeriladiganSavollarKategoriyaAdapter.ViewHolder,
        position: Int,
    ) {
        try {

            holder.bind(list[position])
            holder.itemView.setOnClickListener({
                listener.onclick(list[position].type)
                column_index = position
                notifyDataSetChanged()
            })
            if (column_index === position) {
                holder.binding.btnText.setTextColor(Color.parseColor("#000000"))
                holder.binding.card.setStrokeColor(Color.parseColor("#228FFF"))
            } else {
                holder.binding.btnText.setTextColor(Color.parseColor("#999999"))
                holder.binding.card.setStrokeColor(Color.parseColor("#999999"))

            }
        } catch (e: Exception) {
            D.d(e.message.toString())
        }

    }

    override fun getItemCount(): Int = list.size

    fun setData(list: List<FAQTYPE>) {
        this.list = list
        notifyDataSetChanged()
    }
}