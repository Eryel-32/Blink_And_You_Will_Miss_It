package screens

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import camera.CameraPreview

@Composable
fun CameraCalibratorScreen(
    onContinue: () -> Unit
) {
    var cameraPermissionGranted by remember {
        mutableStateOf(false)
    }

    val permissionLauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission()
        ) {granted -> cameraPermissionGranted = granted}

    LaunchedEffect(Unit) {
        permissionLauncher.launch(Manifest.permission.CAMERA)
    }

    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFFE5E5E5)).padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            text = "Camera Calibration",
            color = Color(0xFF222222),
            fontSize = 32.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        if (cameraPermissionGranted) {
            Box(
                modifier = Modifier.width(400.dp).height(200.dp).background(Color.Black),
                contentAlignment = Alignment.Center
            ) {
                CameraPreview(
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Position your face in front of the camera.",
                color = Color(0xFF222222),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            // CONTINUE BUTTON
            Button(
                onClick = onContinue,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF333333)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Continue",
                    fontSize = 22.sp,
                    color = Color.White
                )
            }

        }

        else {
            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Camera permission is required to continue.",
                color = Color(0xFF222222),
                fontSize = 22.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    permissionLauncher.launch(Manifest.permission.CAMERA)
                }
            ) {
                Text(
                    text = "Grant camera permission",
                    fontSize = 22.sp
                )
            }
        }
    }
}

class CameraCalibratorScreen {
}