package com.example.stsotre.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorPalette = darkColors(
    primary = Purple200,
    secondary = Teal200,
    primaryVariant = Pink700
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    secondary = Teal200,
    primaryVariant = Pink700


)

@Composable
fun STStoreTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {

        DarkColorPalette
    }
    else {
        LightColorPalette
    }



    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes= Shapes(),
        content = content
    )
}