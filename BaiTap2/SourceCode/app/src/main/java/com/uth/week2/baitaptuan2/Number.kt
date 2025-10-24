package com.uth.week2.baitaptuan2

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color

@Composable
fun NumberScreen() {
    var inputText by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("THỰC HÀNH 2 - BÀI 1")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Nhập số") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            // If it is empty
            if (inputText.isEmpty()) {
                resultText = "Vui lòng nhập số"
            } else {
                var isNumber = true

                // Iterate through each character to check if it is a number
                for (c in inputText) {
                    if (!c.isDigit()) {
                        isNumber = false
                    }
                }

                if (isNumber) {
                    val n = inputText.toInt()
                    var s = ""
                    for (i in 1..n) {
                        s += "$i \n"
                    }
                    resultText = "$s"
                } else {
                    resultText = "Dữ liệu bạn nhập không hợp lệ"
                }
            }
        }) {
            Text("Tạo")
        }

        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = resultText,
            color = Color.Red,
            modifier = Modifier.padding(top = 12.dp)
        )

    }
}
