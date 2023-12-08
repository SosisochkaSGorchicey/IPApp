package com.example.ipapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.ipapp.presentation.screen.MainScreen
import com.example.ipapp.ui.theme.IPAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IPAppTheme{
                MainScreen()
            }
        }
    }
}