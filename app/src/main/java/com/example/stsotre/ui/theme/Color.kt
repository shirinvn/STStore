package com.example.stsotre.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFed1b34)
val Purple500 = Color(0xFFFA465B)
val Pink700 = Color(0xFF3700B3)

val Teal200 = Color(0xFF03DAC5)


val Colors.splashBg : Color
    @Composable
    get() = Color(0xFFed1b34)

val Colors.selectedBar : Color
    @Composable
    get() =if (isLight) Color(0xFF686464) else Color(0xFFCFD4DA)

val Colors.unselectedBar : Color
    @Composable
    get() =if (isLight) Color(0xFF686464) else Color(0xFFCFD4DA)

val Colors.searchBarBg : Color
    @Composable
    get() =if (isLight) Color(0xFFF1F0EE) else Color(0xFF303235)

val Colors.darkText : Color
    @Composable
    get() =if (isLight) Color(0xFF414244) else Color(0xFFD8D8D8)

val Colors.semiDarkText : Color
    @Composable
    get() =if (isLight) Color(0xFF5C5E61) else Color(0xFFD8D8D8)


val Colors.amber : Color
    @Composable
    get() = Color(0xffFFBF00)


val Colors.grayCategory : Color
    @Composable
    get() = Color(0xFFF1F0EE)

val Colors.DigiKalaRed : Color
    @Composable
    get() =if (isLight) Color(0xffef4056) else Color(0xFF8D2633)
val Colors.bottomBar : Color
    @Composable
    get() =if (isLight) Color(0xFFFFFFFF) else Color(0xFF303235)


val Colors.DigiKalaRedText : Color
    @Composable
    get() =if (isLight) Color(0xffef4056) else Color(0xFFFFFFFF)
val Colors.DigikalaDarkRed : Color
    @Composable
    get() = Color(0xFFe6123d)
val Colors.DigikalaRed : Color
    @Composable
    get() = Color(0xFFed1b34)

val Colors.DarkCyan : Color
    @Composable
    get() = Color(0xFF0fabc6)


val Colors.LightCyan : Color
    @Composable
    get() = Color(0xFF17BFD3)

val Colors.DigiKalaLightGreen : Color
    @Composable
    get() = if (isLight)  Color(0xff86bf3c)else Color(0xFF3A531A)