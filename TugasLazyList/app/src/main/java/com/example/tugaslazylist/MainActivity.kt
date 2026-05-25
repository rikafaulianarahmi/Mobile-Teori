package com.example.tugaslazylist

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.tugaslazylist.ui.theme.TugasLazyListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TugasLazyListTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val listItem = remember {
                        mutableStateListOf(
                            ItemModel(R.mipmap.ic_launcher, "Item Pertama", "Deskripsi item kesatu", false),
                            ItemModel(R.mipmap.ic_launcher, "Item Kedua", "Deskripsi item kedua", false),
                            ItemModel(R.mipmap.ic_launcher, "Item Ketiga", "Deskripsi item ketiga", false),
                            ItemModel(R.mipmap.ic_launcher, "Item Keempat", "Deskripsi item keempat", false),
                            ItemModel(R.mipmap.ic_launcher, "Item Kelima", "Deskripsi item kelima", false),
                        )
                    }

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        itemsIndexed(listItem) { index, item ->
                            ItemCard(
                                item = item,
                                position = index,
                                onSwitchChanged = { isChecked ->
                                    // Update state item
                                    listItem[index] = item.copy(isSwitchOn = isChecked)
                                    if (isChecked) {
                                        Toast.makeText(
                                            this@MainActivity,
                                            "Switch hidup pada item ${index + 1}",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                },
                                onAksiClick = {
                                    Toast.makeText(
                                        this@MainActivity,
                                        "Tombol telah ditekan untuk tombol ${index + 1}",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}