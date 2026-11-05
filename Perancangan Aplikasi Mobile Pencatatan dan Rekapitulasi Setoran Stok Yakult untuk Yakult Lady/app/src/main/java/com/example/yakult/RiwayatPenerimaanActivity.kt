package com.example.yakult

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.yakult.ui.screens.RiwayatPenerimaanScreen
import com.example.yakult.ui.theme.YakultTheme

class RiwayatPenerimaanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            YakultTheme {
                RiwayatPenerimaanScreen(
                    onBerandaClick = { finish() },
                    onBantuanClick = {
                        Toast.makeText(this, getString(R.string.toast_bantuan), Toast.LENGTH_SHORT).show()
                    },
                    onLihatDetailClick = { date ->
                        Toast.makeText(this, "${getString(R.string.toast_lihat_detail)} - $date", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }
}
