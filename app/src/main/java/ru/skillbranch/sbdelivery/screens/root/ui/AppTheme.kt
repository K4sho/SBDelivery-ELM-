package ru.skillbranch.sbdelivery.screens.root.ui

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import ru.skillbranch.sbdelivery.ui.theme.Purple200
import ru.skillbranch.sbdelivery.ui.theme.Purple700
import ru.skillbranch.sbdelivery.ui.theme.Teal200

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = DarkColorPalette,
        content = content
    )
}