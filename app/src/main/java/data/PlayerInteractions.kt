package data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player_interactions")
data class PlayerInteraction(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val sceneId: Int,

    val objectId: String,

    val interacted: Boolean = true
)

