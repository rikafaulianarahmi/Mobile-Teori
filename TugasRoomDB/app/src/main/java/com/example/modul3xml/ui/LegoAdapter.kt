package com.example.modul3xml.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.modul3xml.data.model.LegoSetWithTheme
import com.example.modul3xml.databinding.ItemLegoBinding

class LegoAdapter(
    private var listData: List<LegoSetWithTheme> = emptyList(),
    private val onDetailClick: (LegoSetWithTheme) -> Unit,
    private val onWebClick: (LegoSetWithTheme) -> Unit
) : RecyclerView.Adapter<LegoAdapter.LegoViewHolder>() {

    class LegoViewHolder(val binding: ItemLegoBinding) : RecyclerView.ViewHolder(binding.root)

    fun updateData(newList: List<LegoSetWithTheme>) {
        listData = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LegoViewHolder {
        val view = ItemLegoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LegoViewHolder(view)
    }

    override fun onBindViewHolder(holder: LegoViewHolder, position: Int) {
        val item = listData[position]
        holder.binding.tvTitle.text = item.legoSet.title
        holder.binding.tvYear.text = item.legoSet.year.toString()
        holder.binding.tvTheme.text = item.theme.name
        holder.binding.tvDescription.text = item.legoSet.description
        holder.binding.ivLego.setImageResource(item.legoSet.imageRes)

        holder.binding.btnWeb.setOnClickListener { onWebClick(item) }
        holder.binding.btnDetail.setOnClickListener { onDetailClick(item) }
    }

    override fun getItemCount(): Int = listData.size
}