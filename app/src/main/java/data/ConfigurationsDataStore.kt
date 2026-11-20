package data


import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "user_configurations")
class ConfigurationsDataStore(private val context: Context) {

    companion object {
        val SENSITIVITY = floatPreferencesKey("sensitivity")
        val MUSIC_VOLUME = floatPreferencesKey("music_volume")
        val SOUND_VOLUME = floatPreferencesKey("sound_volume")
        val CAMERA_ENABLED = booleanPreferencesKey("camera_enabled")
        val FONT_SIZE = floatPreferencesKey("font_size")
        val SUBTITLES_ENABLED = booleanPreferencesKey("subtitles_enabled")
    }

    // Retrieve settings
    val sensitivity: Flow<Float> =
        context.dataStore.data.map { it[SENSITIVITY] ?: 50f }

    val musicVolume: Flow<Float> =
        context.dataStore.data.map { it[MUSIC_VOLUME] ?: 70f }

    val soundVolume: Flow<Float> =
        context.dataStore.data.map { it[SOUND_VOLUME] ?: 70f }

    val cameraEnabled: Flow<Boolean> =
        context.dataStore.data.map { it[CAMERA_ENABLED] ?: true }

    val fontSize: Flow<Float> =
        context.dataStore.data.map { it[FONT_SIZE] ?: 24f }

    val subtitlesEnabled: Flow<Boolean> =
        context.dataStore.data.map { it[SUBTITLES_ENABLED] ?: true }

    // Save settings
    suspend fun saveSensitivity(value: Float) {
        context.dataStore.edit { it[SENSITIVITY] = value }
    }

    suspend fun saveMusicVolume(value: Float) {
        context.dataStore.edit { it[MUSIC_VOLUME] = value }
    }

    suspend fun saveSoundVolume(value: Float) {
        context.dataStore.edit { it[SOUND_VOLUME] = value }
    }

    suspend fun saveCameraEnabled(value: Boolean) {
        context.dataStore.edit { it[CAMERA_ENABLED] = value }
    }

    suspend fun saveFontSize(value: Float) {
        context.dataStore.edit { it[FONT_SIZE] = value }
    }

    suspend fun saveSubtitlesEnabled(value: Boolean) {
        context.dataStore.edit { it[SUBTITLES_ENABLED] = value }
    }
}
