package com.example.tugaslazylist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ItemCard(
    item: ItemModel,
    position: Int,
    onSwitchChanged: (Boolean) -> Unit,
    onAksiClick: () -> Unit
) {
    val backgroundColor = if (position % 2 == 1) {
        Color(0xFFD8F5A2)
    } else {
        Color.White
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        androidx.compose.foundation.Image(
            painter = painterResource(id = item.imageRes),
            contentDescription = "Gambar item",
            modifier = Modifier
                .size(60.dp)
                .background(Color.LightGray, RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = item.nama,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = item.deskripsi,
                fontSize = 13.sp,
                color = Color.Gray
            )
        }

        // Switch & Tombol
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Switch(
                checked = item.isSwitchOn,
                onCheckedChange = { onSwitchChanged(it) }
            )
            Button(
                onClick = onAksiClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6650A4)
                ),
                shape = RoundedCornerShape(50.dp)
            ) {
                Text(text = "Aksi", color = Color.White)
            }
        }
    }
}