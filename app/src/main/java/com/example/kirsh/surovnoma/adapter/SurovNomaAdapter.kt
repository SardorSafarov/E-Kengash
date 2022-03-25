package com.example.kirsh.surovnoma.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.katrip.R
import com.example.katrip.databinding.ItemSurovnomaBinding
import com.example.log.D
import com.example.network.entity.surovNoma.sayohatTurlari.response.Survey

class SurovNomaAdapter(private val listener: onClickListener, var applicationContext: Context) :
    RecyclerView.Adapter<SurovNomaAdapter.ViewHolder>() {

    private var list: MutableList<Survey> = mutableListOf()

    interface onClickListener {
        fun surovNomaOnclick(surveyId: Int, id: Int)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemSurovnomaBinding.bind(itemView)

        fun bind(item: Survey) {
            Glide.with(applicationContext).load(item.image_link).into(binding.surovNomaImage)
            binding.surovNomaText.setText(item.name)
            itemView.setOnClickListener {
                listener.surovNomaOnclick(item.survey_id, item.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_surovnoma, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        try {
            holder.bind(list[position])
        } catch (e: Exception) {
            D.d("${e.message}")
        }

    }

    override fun getItemCount(): Int = list.size

    fun getData(survey: List<Survey>) {
        this.list = survey as MutableList<Survey>
        notifyDataSetChanged()
    }

}