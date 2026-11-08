package com.griffith.blink_and_you_will_miss_it

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import screens.CameraCalibratorScreen
import screens.ConfigurationsScreen
import screens.CreditsScreen
import screens.HomeScreen
import screens.IntroScreen
import screens.StartScreen

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
                                currentScreen = "cameraCalibration"
                            }
                        )

                        "cameraCalibration" -> CameraCalibratorScreen(
                            onContinue  = {
                                currentScreen = "home"
                            }
                        )

                        "home" -> HomeScreen (
                            onStart = {
                                currentScreen = "start"
                            },
                            onConfigurations = {
                                currentScreen = "configurations"
                            },
                            onCredits = {
                                currentScreen = "credits"
                            }
                        )

                        "start" -> StartScreen(
                            onNewGame = {
                                currentScreen = "story"
                            },
                            onContinue = {
                                currentScreen = "story"
                            },
                            onBack = {
                                currentScreen = "home"
                            }
                        )

                        "configurations" -> ConfigurationsScreen(
                            onBack = {
                                currentScreen = "home"
                            }
                        )

                        "credits" -> CreditsScreen(
                            onBack = {
                                currentScreen = "home"
                            }
                        )
                    }
                }
            }
        }
    }
}


