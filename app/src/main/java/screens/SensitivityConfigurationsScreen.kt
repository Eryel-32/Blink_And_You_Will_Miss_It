
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
fun SensitivityConfigurationScreen(
    onBack: () -> Unit
) {

    val context = LocalContext.current
    val dataStore = remember { ConfigurationsDataStore(context) }
    val scope = rememberCoroutineScope()

    // saved sensitivity
    val savedSensitivity by dataStore.sensitivity.collectAsState(initial = 50f)

    // local slider value
    var sensitivity by remember {
        mutableFloatStateOf(50f)
    }

    //update the slider
    LaunchedEffect((savedSensitivity)) { sensitivity = savedSensitivity}

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Controller Sensitivity",
            fontSize = 40.sp,
            fontFamily = eva16
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "${sensitivity.toInt()}%",
            fontSize = 24.sp,
            fontFamily = eva16
        )

        Slider(
            value = sensitivity,
            onValueChange = { sensitivity = it },
            onValueChangeFinished = {scope.launch {
                dataStore.saveSensitivity(sensitivity)
            }},
            valueRange = 0f..100f
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Low", fontFamily = eva16)
            Text("High", fontFamily = eva16)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Adjust how quickly the camera responds when you tilt your phone.",
            fontSize = 18.sp,
            fontFamily = eva16
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onBack) {
            Text(
                text = "Back",
                fontFamily = eva16,
                fontSize = 22.sp
            )
        }
    }
}
