package data


import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "game_progress")
data class Progress(
    @PrimaryKey
    val id: Int = 1,
    val currentScene: Int = 1,
    val storyCompleted: Boolean = false,
    val gameStarted: Boolean = false,
    val lastPlayed: Long = System.currentTimeMillis()
)

