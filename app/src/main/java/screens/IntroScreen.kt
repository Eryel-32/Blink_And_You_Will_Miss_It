package screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.rememberTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import com.griffith.blink_and_you_will_miss_it.R
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

val eva16 = FontFamily(Font(R.font.eva_16))

@Composable
fun IntroScreen(
    onContinue: () -> Unit
){
    var fade by remember { mutableStateOf(false) }

    val alpha by animateFloatAsState(
        targetValue = if(fade) 0f else 1f,
        animationSpec = tween(durationMillis = 1500),
        label = "IntroFade"
    )

    LaunchedEffect(Unit) {
        delay(5000.milliseconds) // 5 secs
        fade = true
        delay(1500.milliseconds) // wait for animation
        onContinue()
    }

    Column(
        modifier = Modifier.fillMaxSize().graphicsLayer { this.alpha = alpha },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
    ) {
        Text(
            text = "Blink And You Will Miss It",
            fontSize = 100.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = eva16
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Your story begins here..." ,
            fontFamily = eva16,
            fontSize = 50.sp
        )
    }
}