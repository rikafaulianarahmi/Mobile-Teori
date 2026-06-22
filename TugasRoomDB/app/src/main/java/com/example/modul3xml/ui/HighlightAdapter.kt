package com.example.modul3xml.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.modul3xml.data.model.LegoSetWithTheme
import com.example.modul3xml.databinding.ItemHighlightBinding

class HighlightAdapter(
    private var list: List<LegoSetWithTheme> = emptyList()
) : RecyclerView.Adapter<HighlightAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemHighlightBinding) : RecyclerView.ViewHolder(binding.root)

    fun updateData(newList: List<LegoSetWithTheme>) {
        list = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHighlightBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.ivHighlight.setImageResource(list[position].legoSet.imageRes)
    }

    override fun getItemCount(): Int = list.size
}