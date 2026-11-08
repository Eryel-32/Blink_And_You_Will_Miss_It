package camera

import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.LocalLifecycleOwner

@Composable
fun CameraPreview(
    modifier: Modifier = Modifier.fillMaxWidth(0.5f).height(220.dp)
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    val previewView = remember {
        PreviewView(context)
    }

    DisposableEffect(lifecycleOwner) {

        val cameraProviderFuture = ProcessCameraProvider.getInstance(context)
        var cameraProvider: ProcessCameraProvider? = null
        var cameraPreview: Preview? = null
        cameraProviderFuture.addListener({

            try {
                cameraProvider = cameraProviderFuture.get()
                val preview = Preview.Builder().build()
                cameraPreview = preview
                preview.setSurfaceProvider(previewView.surfaceProvider)
                cameraProvider?.unbindAll()

                cameraProvider?.bindToLifecycle(lifecycleOwner, CameraSelector.DEFAULT_FRONT_CAMERA, preview)

            }

            catch (e: Exception) {
                android.util.Log.e("CameraPreview", "Unable to start camera", e
                )
            }

        }, ContextCompat.getMainExecutor(context))

        onDispose {
            cameraPreview?.let {
                cameraProvider?.unbind(it)
            }
        }
    }

    AndroidView(
        factory = { previewView },
        modifier = modifier
    )
}

class CameraPreview {
}