package com.sbellanger.mergedadapter.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sbellanger.mergedadapter.R
import com.sbellanger.mergedadapter.domain.data.FooterEntity
import kotlinx.android.synthetic.main.view_footer.view.*

class FooterAdapter : RecyclerView.Adapter<FooterAdapter.FooterViewHolder>() {

    private var footerEntity: FooterEntity? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FooterViewHolder {
        return FooterViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.view_footer, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: FooterViewHolder, position: Int) {
        footerEntity?.let {
            holder.bind(it)
        }
    }

    fun setData(data: FooterEntity) {
        footerEntity = data
        notifyDataSetChanged()
    }

    open class FooterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(data: FooterEntity) {
            with(itemView) {
                footer_credentials.text = StringBuilder().apply {
                    append(data.name)
                    append("\n")
                    append(data.email)
                }
            }
        }
    }
}