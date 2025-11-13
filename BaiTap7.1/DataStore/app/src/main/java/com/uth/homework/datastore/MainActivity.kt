// Vẫn giữ nguyên như trước
package com.uth.homework.datastore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.uth.homework.datastore.data.ThemePreferenceManager
import com.uth.homework.datastore.ui.ThemeSelectorScreen
import com.uth.homework.datastore.ui.theme.DataStoreTheme

class MainActivity : ComponentActivity() {

    private val themeManager by lazy { ThemePreferenceManager(applicationContext) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val currentTheme by themeManager.getThemeFlow().collectAsState(
                initial = ThemePreferenceManager.DEFAULT_THEME
            )

            DataStoreTheme(selectedTheme = currentTheme) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ThemeSelectorScreen(
                        themePreferenceManager = themeManager,
                        currentSavedTheme = currentTheme, // Truyền theme đã lưu
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}