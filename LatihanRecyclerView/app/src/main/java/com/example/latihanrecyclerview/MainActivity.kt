package com.example.latihanrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihanrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listItem = mutableListOf(
            ItemModel(R.mipmap.ic_launcher, "Item Pertama", "Deskripsi item kesatu", false),
            ItemModel(R.mipmap.ic_launcher, "Item Kedua", "Deskripsi item kedua", false),
            ItemModel(R.mipmap.ic_launcher, "Item Ketiga", "Deskripsi item ketiga", false),
            ItemModel(R.mipmap.ic_launcher, "Item Keempat", "Deskripsi item keempat", false),
            ItemModel(R.mipmap.ic_launcher, "Item Kelima", "Deskripsi item kelima", false),
        )

        adapter = ItemAdapter(listItem)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }
}