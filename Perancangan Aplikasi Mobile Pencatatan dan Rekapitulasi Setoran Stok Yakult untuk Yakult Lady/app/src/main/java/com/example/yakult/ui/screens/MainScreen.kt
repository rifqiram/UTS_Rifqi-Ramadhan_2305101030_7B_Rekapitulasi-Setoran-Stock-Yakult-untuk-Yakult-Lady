package com.example.yakult.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yakult.R
import com.example.yakult.ui.theme.*

@Composable
fun MainScreen(
    onAddReceiptClick: () -> Unit,
    onLihatDetailClick: (String) -> Unit
) {
    var currentTab by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            Surface(
                tonalElevation = 8.dp,
                color = SurfaceLight
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Beranda
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.clickable { currentTab = 0 }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_home),
                            contentDescription = "Beranda",
                            tint = if (currentTab == 0) PrimaryRed else TextSecondary,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "Beranda",
                            color = if (currentTab == 0) PrimaryRed else TextSecondary,
                            fontSize = 12.sp,
                            fontWeight = if (currentTab == 0) FontWeight.Bold else FontWeight.Normal
                        )
                    }

                    // Riwayat
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.clickable { currentTab = 1 }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_clipboard),
                            contentDescription = "Riwayat",
                            tint = if (currentTab == 1) PrimaryRed else TextSecondary,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "Riwayat",
                            color = if (currentTab == 1) PrimaryRed else TextSecondary,
                            fontSize = 12.sp,
                            fontWeight = if (currentTab == 1) FontWeight.Bold else FontWeight.Normal
                        )
                    }

                    // Bantuan
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.clickable { currentTab = 2 }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_help),
                            contentDescription = "Bantuan",
                            tint = if (currentTab == 2) PrimaryRed else TextSecondary,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "Bantuan",
                            color = if (currentTab == 2) PrimaryRed else TextSecondary,
                            fontSize = 12.sp,
                            fontWeight = if (currentTab == 2) FontWeight.Bold else FontWeight.Normal
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (currentTab) {
                0 -> DashboardScreen(
                    onAddReceiptClick = onAddReceiptClick,
                    onSeeAllClick = { currentTab = 1 },
                    onRiwayatClick = { currentTab = 1 },
                    onBantuanClick = { currentTab = 2 }
                )
                1 -> RiwayatPenerimaanScreen(
                    onBerandaClick = { currentTab = 0 },
                    onBantuanClick = { currentTab = 2 },
                    onLihatDetailClick = onLihatDetailClick
                )
                2 -> BantuanScreen(
                    onBerandaClick = { currentTab = 0 },
                    onRiwayatClick = { currentTab = 1 }
                )
            }
        }
    }
}
