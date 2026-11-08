package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import com.griffith.blink_and_you_will_miss_it.R
import java.nio.file.WatchEvent

@Composable
fun CreditsScreen(
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Credits",
            fontSize = 40.sp,
            fontFamily = eva16,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(40.dp))

        Text("Game Development", fontFamily = eva16)
        Text("Art and Design", fontFamily = eva16)
        Text("Sound and Music", fontFamily = eva16)
        Text("Story and Writing", fontFamily = eva16)

        Spacer(modifier = Modifier.height(40.dp))

        Button(onClick = onBack) {
            Text("Back", fontFamily = eva16, fontSize = 40.sp)
        }
    }
}

class CreditsScreen {
}