package com.example.yakult.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yakult.ui.theme.*

@Composable
fun BantuanScreen(
    onBerandaClick: () -> Unit,
    onRiwayatClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLight)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Text(
                text = "Bantuan & Panduan",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Informasi penggunaan aplikasi Yakult Stock",
                fontSize = 14.sp,
                color = TextSecondary
            )

            Spacer(modifier = Modifier.height(20.dp))

            HelpCard(
                title = "Cara Mencatat Penerimaan Stok",
                description = "Tekan tombol '+ Tambah Penerimaan' di halaman Beranda, pilih tanggal, lalu masukkan jumlah botol per varian produk (Original, Mangga, Less Sugar, Strawberry). Total akan dihitung secara otomatis."
            )

            Spacer(modifier = Modifier.height(12.dp))

            HelpCard(
                title = "Melihat Riwayat Penerimaan",
                description = "Buka tab 'Riwayat' di bagian bawah atau tekan 'Lihat semua' di Beranda untuk melihat daftar riwayat penerimaan sebelumnya beserta rincian varian."
            )

            Spacer(modifier = Modifier.height(12.dp))

            HelpCard(
                title = "Navigasi Geser (Swipe)",
                description = "Anda dapat menggeser layar (swipe) ke kiri atau ke kanan di mana saja untuk berpindah dengan cepat antara Beranda, Riwayat, dan Bantuan."
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun HelpCard(title: String, description: String) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceLight),
        border = BorderStroke(1.dp, BorderColor),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = TextPrimary)
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = description, fontSize = 14.sp, color = TextSecondary, lineHeight = 20.sp)
        }
    }
}
