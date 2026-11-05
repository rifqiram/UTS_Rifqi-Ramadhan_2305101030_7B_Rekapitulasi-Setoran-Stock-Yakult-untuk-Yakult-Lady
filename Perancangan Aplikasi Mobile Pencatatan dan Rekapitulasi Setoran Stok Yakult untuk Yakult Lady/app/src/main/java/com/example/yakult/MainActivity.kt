package com.example.yakult

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.yakult.ui.screens.MainScreen
import com.example.yakult.ui.theme.YakultTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            YakultTheme {
                MainScreen(
                    onAddReceiptClick = {
                        startActivity(Intent(this, TambahPenerimaanActivity::class.java))
                    },
                    onLihatDetailClick = { date ->
                        Toast.makeText(this, "${getString(R.string.toast_lihat_detail)} - $date", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }
}
