package com.guri.guriremoteconfig.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.guri.guriremoteconfig.UIState
import com.guri.guriremoteconfig.util.bounceClick

@Composable
fun RemoteConfigScreen(modifier: Modifier = Modifier, uiState: UIState, triggerEvent: (String) -> Unit) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "Guri Remote Config",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = uiState.text)
        Spacer(modifier = Modifier.padding(8.dp))
        KeyPad(triggerEvent = triggerEvent)
    }
}

@Composable
fun KeyPad(triggerEvent: (String) -> Unit) {
    val numbers = listOf(
        listOf("1", "2", "3"),
        listOf("4", "5", "6"),
        listOf("7", "8", "9")
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        numbers.forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                row.forEach { number ->
                    KeyPadItem(
                        number = number,
                        modifier = Modifier
                            .bounceClick()
                            .weight(1f)
                            .height(75.dp)
                            .shadow(
                                elevation = 1.dp, // Shadow elevation
                                shape = RoundedCornerShape(3), // Shape of the shadow
                                clip = false,
                                ambientColor = Color.Gray,
                                spotColor = Color.Black
                            )
                            .background(color = Color.Transparent)
                            .clickable {
                                triggerEvent(number)
                            }
                    )
                }
            }
        }
    }
}

@Composable
fun KeyPadItem(modifier: Modifier = Modifier, number: String) {
    Text(
        text = number,
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium,
        color = Color.Black,
        modifier = modifier.padding(25.dp),
        textAlign = TextAlign.Center
    )
}