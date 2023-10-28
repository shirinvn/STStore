package com.example.stsotre.nav

import androidx.compose.ui.graphics.painter.Painter

data class BottomNavItem(
    val name:String,
    var route:String,
    val selectedIcon : Painter,
    val deselectedIcon : Painter
)
