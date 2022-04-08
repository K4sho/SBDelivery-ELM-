package ru.skillbranch.sbdelivery

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ru.skillbranch.sbdelivery.screens.ui.DemoScreen
import ru.skillbranch.sbdelivery.ui.theme.SBDeliveryTheme

class MainActivity : AppCompatActivity() {
    private val vm: RootViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SBDeliveryTheme {
                DemoScreen(vm = vm)
            }
        }
    }
}