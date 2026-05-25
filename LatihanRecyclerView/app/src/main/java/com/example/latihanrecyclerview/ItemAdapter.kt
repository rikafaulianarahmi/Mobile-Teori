package com.example.latihanrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanrecyclerview.databinding.ItemListBinding

class ItemAdapter(private val items: MutableList<ItemModel>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ItemModel, position: Int) {
            binding.imgItem.setImageResource(item.imageRes)
            binding.tvNama.text = item.nama
            binding.tvDeskripsi.text = item.deskripsi

            binding.switchItem.setOnCheckedChangeListener(null)
            binding.switchItem.isChecked = item.isSwitchOn

            if (position % 2 == 1) {
                binding.itemContainer.setBackgroundColor("#D8F5A2".toColorInt())
            } else {
                binding.itemContainer.setBackgroundColor("#FFFFFF".toColorInt())
            }

            // Switch listener
            binding.switchItem.setOnCheckedChangeListener { _, isChecked ->
                item.isSwitchOn = isChecked
                if (isChecked) {
                    Toast.makeText(
                        binding.root.context,
                        "Switch hidup pada item ${position + 1}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            binding.btnAksi.setOnClickListener {
                Toast.makeText(
                    binding.root.context,
                    "Tombol telah ditekan untuk tombol ${position + 1}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemListBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position], position)
    }

    override fun getItemCount(): Int = items.size
}