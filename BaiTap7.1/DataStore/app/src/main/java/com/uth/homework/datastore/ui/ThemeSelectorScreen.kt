package com.uth.homework.datastore.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.uth.homework.datastore.data.ThemePreferenceManager
import kotlinx.coroutines.launch

// Định nghĩa các cặp (tên theme, màu đại diện)
// Các màu này chỉ để hiển thị trên nút, không phải màu chính của theme
private val ThemeDisplayData = listOf(
    "Default" to Color(0xFFE0E0E0), // Gần trắng xám
    "Pink" to Color(0xFFE91E63),   // Hồng
    "Dark" to Color(0xFF424242),   // Xám đen (giả định có theme Dark)
    "Blue" to Color(0xFF2196F3)    // Xanh dương
)

@Composable
fun ThemeSelectorScreen(
    themePreferenceManager: ThemePreferenceManager,
    currentSavedTheme: String, // Theme hiện tại đã được lưu
    modifier: Modifier = Modifier
) {
    val coroutineScope = rememberCoroutineScope()
    // Sử dụng mutableStateOf để quản lý theme TẠM THỜI được chọn trên UI,
    // trước khi nhấn APPLY. Ban đầu sẽ là theme đã lưu.
    var selectedThemeForUI by remember { mutableStateOf(currentSavedTheme) }

    // Khi currentSavedTheme thay đổi (ví dụ: từ màn hình khác lưu theme),
    // cập nhật selectedThemeForUI để đồng bộ
    LaunchedEffect(currentSavedTheme) {
        selectedThemeForUI = currentSavedTheme
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(64.dp)) // Padding trên đầu

        Text(
            text = "Setting",
            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Choosing the right theme sets the tone and personality of your app.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))

        // Hàng chứa các ô chọn theme
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ThemeDisplayData.forEach { (themeName, displayColor) ->
                ThemeOptionBox(
                    themeName = themeName,
                    displayColor = displayColor,
                    isSelected = (selectedThemeForUI == themeName),
                    onClick = {
                        selectedThemeForUI = themeName // Cập nhật lựa chọn tạm thời
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(48.dp))

        // Nút Apply
        Button(
            onClick = {
                // Lưu theme đã chọn TẠM THỜI vào DataStore khi nút Apply được nhấn
                coroutineScope.launch {
                    themePreferenceManager.saveTheme(selectedThemeForUI)
                }
            },
            modifier = Modifier
                .fillMaxWidth(0.6f) // Độ rộng tương đối
                .height(50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2196F3) // Màu xanh của nút Apply
            )
        ) {
            Text(
                text = "Apply",
                color = Color.White,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
fun ThemeOptionBox(
    themeName: String,
    displayColor: Color,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val boxSize = 70.dp
    val cornerRadius = 12.dp // Bo tròn các góc

    // BorderStroke sẽ chỉ hiển thị khi isSelected là true
    val border = if (isSelected) {
        BorderStroke(2.dp, MaterialTheme.colorScheme.primary) // Viền màu primary
    } else {
        null // Không có viền
    }

    Card(
        modifier = modifier
            .size(boxSize)
            .clip(RoundedCornerShape(cornerRadius))
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(cornerRadius),
        colors = CardDefaults.cardColors(containerColor = displayColor),
        border = border // Áp dụng viền
    ) {
        // Có thể thêm icon hoặc text vào đây nếu muốn, hiện tại để trống để chỉ hiển thị màu
        Box(modifier = Modifier.fillMaxSize())
    }
}