package com.sbellanger.mergedadapter.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.sbellanger.mergedadapter.R
import com.sbellanger.mergedadapter.domain.data.MainDataEntity
import kotlinx.android.synthetic.main.view_main.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private val mainData: MutableList<MainDataEntity> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.view_main, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return mainData.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val data = mainData[position]
        holder.bind(data)
    }

    fun setData(data: List<MainDataEntity>) {
        mainData.addAll(data)
        notifyDataSetChanged()
    }

    open class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(data: MainDataEntity) {
            with(itemView) {
                main_icon.setImageResource(data.imageResId)
                main_name.text = data.name
                main_description.text = data.description
                main_indicator.setBackgroundColor(ContextCompat.getColor(context, data.colorRes))
            }
        }
    }
}