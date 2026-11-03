package com.esyhonotdead.vkedukotlinhw1.ui.theme

import androidx.compose.ui.graphics.Color

fun getCardColor(number: Int): Color {
    return if (number % 2 == 0) {
        Color.Red
    } else {
        Color.Blue
    }
}