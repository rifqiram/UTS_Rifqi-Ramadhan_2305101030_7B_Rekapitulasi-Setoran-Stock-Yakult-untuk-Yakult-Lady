package com.example.yakult

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.yakult.ui.screens.TambahPenerimaanScreen
import com.example.yakult.ui.theme.YakultTheme

class TambahPenerimaanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            YakultTheme {
                TambahPenerimaanScreen(
                    onBackClick = { finish() },
                    onSaveSuccess = {
                        Toast.makeText(this, getString(R.string.toast_save_success), Toast.LENGTH_SHORT).show()
                        finish()
                    }
                )
            }
        }
    }
}
