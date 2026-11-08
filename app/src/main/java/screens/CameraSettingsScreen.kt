package screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CameraSettingsScreen(
    onBack: () -> Unit
) {
    var cameraEnabled by remember {
        mutableStateOf(true)
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Camera Settings",
            fontSize = 40.sp,
            fontFamily = eva16
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text("Camera", fontFamily = eva16, fontSize = 24.sp)

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Camera enabled", fontFamily = eva16)

            Switch(
                checked = cameraEnabled,
                onCheckedChange = { cameraEnabled = it }
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = onBack) {
            Text("Back", fontFamily = eva16)
        }
    }
}