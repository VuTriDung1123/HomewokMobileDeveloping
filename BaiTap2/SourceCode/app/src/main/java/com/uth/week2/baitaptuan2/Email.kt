package com.uth.week2.baitaptuan2

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color

@Composable
fun EmailScreen() {
    var email by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("THỰC HÀNH 2 - BÀI 2")

            Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Nhập email") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            //Check if it is empty
            if (email.isEmpty()) {
                result = "Email không hợp lệ"
            } else {
                var hasAt = false
                for (c in email) {
                    if (c == '@') hasAt = true
                }

                if (hasAt) {
                    result = "Email hợp lệ"
                } else {
                    result = "Email không đúng định dạng"
                }
            }
        }) {
            Text("Kiểm tra")
        }

        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = result,
            color = Color.Red,
            modifier = Modifier.padding(top = 12.dp)
        )
    }
}
