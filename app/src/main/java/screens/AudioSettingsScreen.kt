package screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AudioSettingsScreen(
    onBack: () -> Unit
) {
    var musicVolume by remember {
        mutableFloatStateOf(70f)
    }

    var soundVolume by remember {
        mutableFloatStateOf(70f)
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Audio Settings",
            fontSize = 40.sp,
            fontFamily = eva16
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Music Volume: ${musicVolume.toInt()}%",
            fontSize = 22.sp,
            fontFamily = eva16
        )

        Slider(
            value = musicVolume,
            onValueChange = { musicVolume = it },
            valueRange = 0f..100f
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Sound Effects: ${soundVolume.toInt()}%",
            fontSize = 22.sp,
            fontFamily = eva16
        )

        Slider(
            value = soundVolume,
            onValueChange = { soundVolume = it },
            valueRange = 0f..100f
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = onBack) {
            Text("Back", fontFamily = eva16)
        }
    }
}
