package com.uth.week2.baitaptuan2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                NavigationApp()
            }
        }
    }
}

@Composable
fun NavigationApp() {
    var currentScreen by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {


        Spacer(modifier = Modifier.height(16.dp))

        // Navigation with arrows
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left arrow button
            IconButton(
                onClick = {
                    // If on screen 1, switch to 3; otherwise, decrease by 1
                    if (currentScreen == 1) {
                        currentScreen = 3
                    } else {
                        currentScreen--
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Previous",
                    modifier = Modifier.size(32.dp)
                )
            }

            // Display the current screen name
            Text(
                text = when (currentScreen) {
                    1 -> "Bài 1: Number"
                    2 -> "Bài 2: Email"
                    3 -> "Bài 3: Info"
                    else -> ""
                },
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            // Right arrow button
            IconButton(
                onClick = {
                    // If on screen 3, switch to 1; otherwise, increase by 1
                    if (currentScreen == 3) {
                        currentScreen = 1
                    } else {
                        currentScreen++
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Next",
                    modifier = Modifier.size(32.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Content based on current screen
        when (currentScreen) {
            1 -> NumberScreen()
            2 -> EmailScreen()
            3 -> InfoScreen()
        }
    }
}

