package com.uth.homework.datastore.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

// --- Định nghĩa các Color Schemes ---

// Default Light Color Scheme (trắng)
private val LightDefaultColorScheme = lightColorScheme(
    primary = Color(0xFF2196F3), // Xanh cho nút Apply/viền
    onPrimary = Color.White,
    background = Color.White,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black,
    onSurfaceVariant = Color.Gray
)

// Default Dark Color Scheme (xám đen)
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF2196F3), // Xanh cho nút Apply/viền
    onPrimary = Color.White,
    background = Color(0xFF121212), // Nền rất tối
    onBackground = Color.White,
    surface = Color(0xFF1E1E1E),
    onSurface = Color.White,
    onSurfaceVariant = Color.LightGray
)

// Pink Theme Color Scheme
private val PinkColorScheme = lightColorScheme(
    primary = Color(0xFFE91E63), // Hồng đậm cho viền/nút
    onPrimary = Color.White,
    background = Color(0xFFE91E63), // Nền hồng nhạt
    onBackground = Color.Black,
    surface = Color(0xFFF8BBD0),
    onSurface = Color.Black,
    onSurfaceVariant = Color.Gray
)

// Blue Theme Color Scheme
private val BlueColorScheme = lightColorScheme(
    primary = Color(0xFF2196F3), // Xanh dương đậm cho viền/nút
    onPrimary = Color.White,
    background = Color(0xFF2196F3), // Nền xanh nhạt
    onBackground = Color.Black,
    surface = Color(0xFF90CAF9),
    onSurface = Color.Black,
    onSurfaceVariant = Color.Gray
)

@Composable
fun DataStoreTheme(
    selectedTheme: String, // Tham số theme được chọn từ DataStore
    content: @Composable () -> Unit
) {
    // Luôn chọn light theme cho các theme màu cụ thể
    // System dark theme chỉ áp dụng cho 'Default' nếu bạn muốn
    val useDarkTheme = false // Mặc định không dùng dark theme từ hệ thống cho các theme màu

    val colorScheme = when (selectedTheme) {
        "Pink" -> PinkColorScheme
        "Blue" -> BlueColorScheme
        "Dark" -> DarkColorScheme // Áp dụng DarkColorScheme khi theme là "Dark"
        else -> LightDefaultColorScheme // Mặc định là LightDefaultColorScheme (trắng)
    }

    // Nếu bạn muốn Default theme tự động chuyển Dark/Light theo hệ thống:
    // val finalColorScheme = if (selectedTheme == "Default" && isSystemInDarkTheme()) DarkDefaultColorScheme else colorScheme

    MaterialTheme(
        colorScheme = colorScheme, // Sử dụng scheme đã chọn
        typography = Typography,
        content = content
    )
}