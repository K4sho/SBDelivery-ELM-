package ru.skillbranch.sbdelivery

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import ru.skillbranch.sbdelivery.screens.root.logic.RootScreen
import ru.skillbranch.sbdelivery.screens.root.ui.AppTheme

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val vm: RootViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                RootScreen(vm = vm)
            }
        }
    }
}