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
fun TextSettingsScreen(
    onBack: () -> Unit
) {
    val context = LocalContext.current
    val dataStore = remember { ConfigurationsDataStore(context) }
    val scope = rememberCoroutineScope()

    // retrive
    val savedFontSize by dataStore.fontSize.collectAsState(initial = 24f)
    val savedSubtitles by dataStore.subtitlesEnabled.collectAsState(initial = true)

    // local settings
    var fontSize by remember {
        mutableFloatStateOf(24f)
    }

    var subtitlesEnabled by remember {
        mutableStateOf(true)
    }

    //update
    LaunchedEffect(savedFontSize) { fontSize = savedFontSize }
    LaunchedEffect(savedSubtitles) { subtitlesEnabled = savedSubtitles }

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
            onValueChange = { scope.launch { dataStore.saveFontSize(fontSize) } },
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
                onCheckedChange = { newValue -> subtitlesEnabled = newValue
                    scope.launch {
                        dataStore.saveSubtitlesEnabled(newValue)
                    }
                }
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = onBack) {
            Text("Back", fontFamily = eva16)
        }
    }
}
