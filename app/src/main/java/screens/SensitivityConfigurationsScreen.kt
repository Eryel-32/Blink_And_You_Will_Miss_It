
package screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SensitivityConfigurationScreen(
    onBack: () -> Unit
) {
    var sensitivity by remember {
        mutableFloatStateOf(50f)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Controller Sensitivity",
            fontSize = 40.sp,
            fontFamily = eva16
        )

        Spacer(modifier = Modifier.height(35.dp))

        Text(
            text = "Camera Sensitivity",
            fontSize = 26.sp,
            fontFamily = eva16
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "${sensitivity.toInt()}%",
            fontSize = 24.sp,
            fontFamily = eva16
        )

        Slider(
            value = sensitivity,
            onValueChange = { sensitivity = it },
            valueRange = 0f..100f
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Low", fontFamily = eva16)
            Text("High", fontFamily = eva16)
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Adjust how quickly the camera responds when you tilt your phone.",
            fontSize = 18.sp,
            fontFamily = eva16
        )

        Spacer(modifier = Modifier.height(35.dp))

        Button(onClick = onBack) {
            Text(
                text = "Back",
                fontFamily = eva16,
                fontSize = 22.sp
            )
        }
    }
}
