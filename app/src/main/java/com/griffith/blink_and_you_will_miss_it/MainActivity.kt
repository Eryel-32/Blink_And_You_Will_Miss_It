
package com.griffith.blink_and_you_will_miss_it

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import screens.IntroScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {

                var currentScreen by remember {
                    mutableStateOf("intro")
                }

                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {

                    when (currentScreen) {

                        "intro" -> IntroScreen(
                            onContinue = {
                                currentScreen = "home"
                            }
                        )

                    }
                }
            }
        }
    }
}

