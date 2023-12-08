package com.example.ipapp.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.ipapp.R

val mainFont = FontFamily(
    fonts = listOf(
        Font(resId = R.font.geist_bold, weight = FontWeight.Bold),
        Font(resId = R.font.geist_bold, weight = FontWeight.Medium),
        Font(resId = R.font.geist_bold, weight = FontWeight.Light),
        Font(resId = R.font.geist_bold, weight = FontWeight.Thin)
    )
)