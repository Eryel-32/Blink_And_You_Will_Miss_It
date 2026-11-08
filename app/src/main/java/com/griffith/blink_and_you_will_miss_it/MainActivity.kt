package com.griffith.blink_and_you_will_miss_it

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import screens.AudioSettingsScreen
import screens.CameraCalibratorScreen
import screens.CameraSettingsScreen
import screens.ConfigurationsScreen
import screens.CreditsScreen
import screens.HomeScreen
import screens.IntroScreen
import screens.SensitivityConfigurationScreen
import screens.StartScreen
import screens.TextSettingsScreen

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
                            onCameraSettings = {
                                currentScreen = "cameraSettings"
                            },
                            onSensitivitySettings = {
                                currentScreen = "sensitivitySettings"
                            },
                            onTextSettings = {
                                currentScreen = "textSettings"
                            },
                            onAudioSettings = {
                                currentScreen = "audioSettings"
                            },
                            onBack = {
                                currentScreen = "home"
                            }
                        )

                        "cameraSettings" -> CameraSettingsScreen(
                            onBack = {
                                currentScreen = "configurations"
                            }
                        )

                        "sensitivitySettings" -> SensitivityConfigurationScreen(
                            onBack = {
                                currentScreen = "configurations"
                            }
                        )

                        "textSettings" -> TextSettingsScreen(
                            onBack = {
                                currentScreen = "configurations"
                            }
                        )

                        "audioSettings" -> AudioSettingsScreen(
                            onBack = {
                                currentScreen = "configurations"
                            }
                        )

                        "textSettings" -> TextSettingsScreen(
                            onBack = {
                                currentScreen = "configurations"
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