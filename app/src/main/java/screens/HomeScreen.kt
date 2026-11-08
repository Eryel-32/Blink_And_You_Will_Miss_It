package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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

@Composable
fun HomeScreen(
    onStart: () -> Unit,
    onConfigurations: () -> Unit,
    onCredits: () -> Unit
){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "Blink And You Will Miss It",
            fontSize = 55.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = eva16,
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(onClick = onStart) {
            Text("Start", fontFamily = eva16, fontSize = 40.sp)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onConfigurations) {
            Text("Configurations", fontFamily = eva16, fontSize = 40.sp)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onCredits) {
            Text("Credits", fontFamily = eva16, fontSize = 40.sp)
        }
    }
}


class HomeScreen {
}