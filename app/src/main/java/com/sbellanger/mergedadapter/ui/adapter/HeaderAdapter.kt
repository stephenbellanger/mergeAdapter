package com.sbellanger.mergedadapter.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sbellanger.mergedadapter.R
import com.sbellanger.mergedadapter.domain.data.HeaderEntity
import kotlinx.android.synthetic.main.view_header.view.*

class HeaderAdapter : RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {

    private var headerEntity: HeaderEntity? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        return HeaderViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.view_header, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        headerEntity?.let {
            holder.bind(it)
        }
    }

    fun setData(data: HeaderEntity) {
        headerEntity = data
        notifyDataSetChanged()
    }

    open class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(data: HeaderEntity) {
            with(itemView) {
                header_title.text = data.title
                header_temperature.text = data.temperature
                header_weather.setImageResource(data.weather)
            }
        }
    }
}