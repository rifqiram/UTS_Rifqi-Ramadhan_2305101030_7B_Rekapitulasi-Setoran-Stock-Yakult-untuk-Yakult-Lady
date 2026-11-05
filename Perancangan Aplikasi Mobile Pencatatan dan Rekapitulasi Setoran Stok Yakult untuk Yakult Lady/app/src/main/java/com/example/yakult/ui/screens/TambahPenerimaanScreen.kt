package com.example.yakult.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yakult.R
import com.example.yakult.ui.theme.*
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

@Composable
fun TambahPenerimaanScreen(
    onBackClick: () -> Unit,
    onSaveSuccess: () -> Unit
) {
    var dateStr by remember { mutableStateOf("10 Oktober 2026") }
    var originalStr by remember { mutableStateOf("1200") }
    var manggaStr by remember { mutableStateOf("0") }
    var lessSugarStr by remember { mutableStateOf("850") }
    var strawberryStr by remember { mutableStateOf("600") }

    val original = originalStr.toIntOrNull() ?: 0
    val mangga = manggaStr.toIntOrNull() ?: 0
    val lessSugar = lessSugarStr.toIntOrNull() ?: 0
    val strawberry = strawberryStr.toIntOrNull() ?: 0

    val total = original + mangga + lessSugar + strawberry
    val isValid = total > 0

    val localeId = Locale.forLanguageTag("id-ID")
    val symbols = DecimalFormatSymbols(localeId).apply { groupingSeparator = '.' }
    val decimalFormat = DecimalFormat("#,###", symbols)

    val origF = decimalFormat.format(original.toLong())
    val manggaF = decimalFormat.format(mangga.toLong())
    val lessSugarF = decimalFormat.format(lessSugar.toLong())
    val strawberryF = decimalFormat.format(strawberry.toLong())
    val totalF = decimalFormat.format(total.toLong())

    Scaffold(
        bottomBar = {
            Surface(
                tonalElevation = 8.dp,
                color = SurfaceLight
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Button(
                        onClick = { if (isValid) onSaveSuccess() },
                        enabled = isValid,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = PrimaryRed,
                            disabledContainerColor = PrimaryRed.copy(alpha = 0.5f)
                        ),
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                    ) {
                        Text(
                            text = "Simpan Penerimaan",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedButton(
                        onClick = { onBackClick() },
                        shape = RoundedCornerShape(14.dp),
                        border = BorderStroke(1.dp, BorderColor),
                        colors = ButtonDefaults.outlinedButtonColors(containerColor = SurfaceLight),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                    ) {
                        Text(
                            text = "Batal",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundLight)
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                // Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { onBackClick() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_back),
                            contentDescription = "Kembali",
                            tint = TextPrimary
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Tambah Penerimaan",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                }

                Text(
                    text = "Catat stok Yakult berdasarkan varian",
                    fontSize = 14.sp,
                    color = TextSecondary,
                    modifier = Modifier.padding(start = 48.dp, top = 2.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Date Section
                Text(
                    text = "Tanggal penerimaan",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = SurfaceLight),
                    border = BorderStroke(1.dp, BorderColor),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { /* Date picker dialog can be triggered */ }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = dateStr, fontSize = 16.sp, color = TextPrimary)
                        Icon(
                            painter = painterResource(id = R.drawable.ic_calendar),
                            contentDescription = "Kalender",
                            tint = TextSecondary,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Variant Grid Section
                Text(
                    text = "Jumlah Produk Diterima",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
                Spacer(modifier = Modifier.height(12.dp))

                // 2x2 Grid using Rows and Columns
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        VariantInputBox(
                            title = "Yakult Original",
                            value = originalStr,
                            onValueChange = { originalStr = it },
                            modifier = Modifier.weight(1f)
                        )
                        VariantInputBox(
                            title = "Yakult Mangga",
                            value = manggaStr,
                            onValueChange = { manggaStr = it },
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        VariantInputBox(
                            title = "Yakult Less Sugar",
                            value = lessSugarStr,
                            onValueChange = { lessSugarStr = it },
                            modifier = Modifier.weight(1f)
                        )
                        VariantInputBox(
                            title = "Yakult Strawberry",
                            value = strawberryStr,
                            onValueChange = { strawberryStr = it },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Boleh diisi 0. Minimal satu varian harus lebih dari 0.",
                    fontSize = 13.sp,
                    color = TextSecondary
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Total Summary Card
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = SurfaceLight),
                    border = BorderStroke(1.dp, BorderColor),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = "Total Penerimaan", fontSize = 14.sp, color = TextSecondary)
                        Spacer(modifier = Modifier.height(4.dp))
                        Row(verticalAlignment = Alignment.Bottom) {
                            Text(
                                text = totalF,
                                fontSize = 36.sp,
                                fontWeight = FontWeight.Bold,
                                color = TextPrimary
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "Botol",
                                fontSize = 16.sp,
                                color = TextSecondary,
                                modifier = Modifier.padding(bottom = 6.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "$origF + $manggaF + $lessSugarF + $strawberryF = $totalF botol",
                            fontSize = 13.sp,
                            color = TextSecondary
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun VariantInputBox(
    title: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceLight),
        border = BorderStroke(1.dp, BorderColor),
        modifier = modifier
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = title, fontSize = 13.sp, color = TextSecondary)
            Spacer(modifier = Modifier.height(6.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = value,
                    onValueChange = onValueChange,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        disabledBorderColor = Color.Transparent
                    ),
                    textStyle = LocalTextStyle.current.copy(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    ),
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "Botol",
                    fontSize = 14.sp,
                    color = TextSecondary
                )
            }
        }
    }
}
