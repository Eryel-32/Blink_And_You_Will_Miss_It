package screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextSettingsScreen(
    onBack: () -> Unit
) {
    var fontSize by remember {
        mutableFloatStateOf(24f)
    }

    var subtitlesEnabled by remember {
        mutableStateOf(true)
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Text Settings",
            fontSize = 40.sp,
            fontFamily = eva16
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Font Size",
            fontSize = 24.sp,
            fontFamily = eva16
        )

        Slider(
            value = fontSize,
            onValueChange = { fontSize = it },
            valueRange = 16f..40f
        )

        Text(
            text = "Example dialogue",
            fontSize = fontSize.sp,
            fontFamily = eva16
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {

            Text("Subtitles", fontFamily = eva16)

            Spacer(modifier = Modifier.width(16.dp))

            Switch(
                checked = subtitlesEnabled,
                onCheckedChange = { subtitlesEnabled = it }
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = onBack) {
            Text("Back", fontFamily = eva16)
        }
    }
}
