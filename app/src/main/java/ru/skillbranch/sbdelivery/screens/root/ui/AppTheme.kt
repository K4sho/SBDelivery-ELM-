package ru.skillbranch.sbdelivery.screens.root.ui

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import ru.skillbranch.sbdelivery.ui.theme.*

val DarkColorPalette = darkColors(
    primary = LighDark,
    primaryVariant = LighDark,
    secondary = Orange
)

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = DarkColorPalette,
        content = content
    )
}