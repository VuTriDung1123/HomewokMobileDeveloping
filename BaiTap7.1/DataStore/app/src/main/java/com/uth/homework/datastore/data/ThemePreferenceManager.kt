package com.uth.homework.datastore.data

// Ví dụ: data/ThemePreferenceManager.kt
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Khai báo một DataStore instance ở cấp cao nhất
// Tên file DataStore sẽ là "settings"
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class ThemePreferenceManager(context: Context) {

    private val dataStore = context.dataStore

    companion object {
        // Key để lưu trữ tên theme (ví dụ: "Light", "Dark", "Pink", "Blue")
        val THEME_KEY = stringPreferencesKey("app_theme")
        const val DEFAULT_THEME = "Default" // Giao diện mặc định
    }

    /**
     * Lấy theme hiện tại dưới dạng Flow
     */
    fun getThemeFlow(): Flow<String> {
        return dataStore.data
            .map { preferences ->
                // Đọc giá trị từ DataStore. Nếu không có, trả về DEFAULT_THEME.
                preferences[THEME_KEY] ?: DEFAULT_THEME
            }
    }

    /**
     * Lưu theme mới
     */
    suspend fun saveTheme(themeName: String) {
        dataStore.edit { preferences ->
            preferences[THEME_KEY] = themeName
        }
    }
}