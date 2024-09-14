package com.guri.guriremoteconfig

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.guri.guriremoteconfig.screens.RemoteConfigScreen
import com.guri.guriremoteconfig.ui.theme.GuriRemoteConfigTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GuriRemoteConfigTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val viewModel: RemoteConfigViewModel =
                        ViewModelProvider(this)[RemoteConfigViewModel::class.java]
                    val state = viewModel.uiState
                    RemoteConfigScreen(
                        modifier = Modifier
                            .padding(innerPadding), state,
                        triggerEvent = {
                            viewModel.triggerEvent(UIEvent.UpdateText(it))
                        }
                    )
                }
            }
        }
    }
}