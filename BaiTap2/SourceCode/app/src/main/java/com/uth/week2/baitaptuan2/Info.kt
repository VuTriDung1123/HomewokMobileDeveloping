package com.uth.week2.baitaptuan2

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color

@Composable
fun InfoScreen() {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("THỰC HÀNH 2 - BÀI 3")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nhập tên") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Nhập tuổi") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            //Check if it is empty
            if (name.isEmpty() || age.isEmpty()) {
                result = "Vui lòng nhập đầy đủ"
            } else {
                var isNumber = true
                for (c in age) {
                    if (!c.isDigit()) isNumber = false
                }
                //Check the age
                if (isNumber) {
                    val tuoi = age.toInt()
                    val loai = if (tuoi > 65) "Người già"
                    else if (tuoi >= 6 && tuoi <= 65) "Người lớn"
                    else if (tuoi >= 2 && tuoi < 6) "Trẻ em"
                    else "Em bé"

                    result = "Tên: $name\nTuổi: $tuoi\nPhân loại: $loai"
                } else {
                    result = "Tuổi phải là số"
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
