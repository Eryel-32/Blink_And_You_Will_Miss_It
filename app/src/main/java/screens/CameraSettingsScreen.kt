package screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.ConfigurationsDataStore
import kotlinx.coroutines.launch

@Composable
fun CameraSettingsScreen(
    onBack: () -> Unit
) {

    val context = LocalContext.current
    val dataStore = remember { ConfigurationsDataStore(context) }
    val scope = rememberCoroutineScope()

    // get values
    val savedCameraEnabled by dataStore.cameraEnabled.collectAsState(initial = true)

    var cameraEnabled by remember {
        mutableStateOf(true)
    }

    // update
    LaunchedEffect(savedCameraEnabled) { cameraEnabled = savedCameraEnabled }

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

        Spacer(modifier = Modifier.height(20.dp))

        Text("Camera", fontFamily = eva16, fontSize = 24.sp)

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Camera enabled", fontFamily = eva16)

            Switch(
                checked = cameraEnabled,
                onCheckedChange = { newValue ->

                    cameraEnabled = newValue

                    scope.launch {
                        dataStore.saveCameraEnabled(newValue)
                    }
                }
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onBack) {
            Text("Back", fontFamily = eva16)
        }
    }
}