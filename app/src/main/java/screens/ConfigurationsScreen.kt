package screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ConfigurationsScreen(
    onCameraSettings: () -> Unit,
    onSensitivitySettings: () -> Unit,
    onTextSettings: () -> Unit,
    onAudioSettings: () -> Unit,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Configurations",
            fontSize = 40.sp,
            fontFamily = eva16
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onCameraSettings) {
            Text("Camera Settings", fontFamily = eva16)
        }

        Button(onClick = onSensitivitySettings) {
            Text("Sensitivity Settings", fontFamily = eva16)
        }

        Button(onClick = onTextSettings) {
            Text("Text Settings", fontFamily = eva16)
        }

        Button(onClick = onAudioSettings) {
            Text("Audio Settings", fontFamily = eva16)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onBack) {
            Text("Back", fontFamily = eva16)
        }
    }
}

class ConfigurationsScreen {
}