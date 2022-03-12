package com.example.chapMenu.profil.shaxsiyProfilTasdiqlash.yuzniScanerlash

import android.Manifest.permission.CAMERA
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.content.pm.PackageManager
import android.content.res.AssetFileDescriptor
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceHolder
import androidx.annotation.RequiresApi
import com.example.ekengash.databinding.ActivityYuzniSkanerlashBinding

class YuzniSkanerlash : AppCompatActivity(),SurfaceHolder.Callback2 {
    lateinit var binding:ActivityYuzniSkanerlashBinding
    lateinit var mediya:MediaPlayer
    lateinit var surfaceHolder: SurfaceHolder
    lateinit var file:AssetFileDescriptor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYuzniSkanerlashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusbar()
        ortgaQaytish()

        surfaceHolder = binding.view.holder
        surfaceHolder.addCallback(this)
        file = assets.openFd("sardor.mp4")
    }

    private fun ortgaQaytish() {
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }

    private fun statusbar() {
        window.statusBarColor = Color.WHITE
    }


    @RequiresApi(Build.VERSION_CODES.N)
    override fun surfaceCreated(surfaceHolde: SurfaceHolder) {
        mediya = MediaPlayer()
        mediya.setDisplay(surfaceHolde)
        mediya.setDataSource(file)
        mediya.prepareAsync()
        mediya.setOnPreparedListener{mediaPlyer -> mediaPlyer.start()}
    }

    override fun surfaceChanged(p0: SurfaceHolder, p1: Int, p2: Int, p3: Int) {

    }

    override fun surfaceDestroyed(p0: SurfaceHolder) {

    }

    override fun surfaceRedrawNeeded(p0: SurfaceHolder) {

    }
}
//
//
//class YuzniSkanerlash : AppCompatActivity(), SurfaceHolder2.Callback, Camera.PictureCallback {
//
//    private lateinit var binding: ActivityYuzniSkanerlashBinding
//
//    private var surfaceHolder: SurfaceHolder? = null
//    private var camera: Camera? = null
//
//    private val neededPermissions = arrayOf(CAMERA, WRITE_EXTERNAL_STORAGE)
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityYuzniSkanerlashBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val result = checkPermission()
//        if (result) {
//            setupSurfaceHolder()
//        }
//    }
//
//    private fun checkPermission(): Boolean {
//        val currentAPIVersion = Build.VERSION.SDK_INT
//        if (currentAPIVersion >= Build.VERSION_CODES.M) {
//            val permissionsNotGranted = ArrayList<String>()
//            for (permission in neededPermissions) {
//                if (ContextCompat.checkSelfPermission(
//                        this,
//                        permission
//                    ) != PackageManager.PERMISSION_GRANTED
//                ) {
//                    permissionsNotGranted.add(permission)
//                }
//            }
//            if (permissionsNotGranted.size > 0) {
//                var shouldShowAlert = false
//                for (permission in permissionsNotGranted) {
//                    shouldShowAlert =
//                        ActivityCompat.shouldShowRequestPermissionRationale(this, permission)
//                }
//
//                val arr = arrayOfNulls<String>(permissionsNotGranted.size)
//                val permissions = permissionsNotGranted.toArray(arr)
//                if (shouldShowAlert) {
//                    showPermissionAlert(permissions)
//                } else {
//                    requestPermissions(permissions)
//                }
//                return false
//            }
//        }
//        return true
//    }
//
//    private fun showPermissionAlert(permissions: Array<String?>) {
//        val alertBuilder = AlertDialog.Builder(this)
//        alertBuilder.setCancelable(true)
//
//        alertBuilder.setPositiveButton("sardor") { _, _ -> requestPermissions(permissions) }
//        val alert = alertBuilder.create()
//        alert.show()
//    }
//
//    private fun requestPermissions(permissions: Array<String?>) {
//        ActivityCompat.requestPermissions(this, permissions, REQUEST_CODE)
//    }
//
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<String>,
//        grantResults: IntArray
//    ) {
//        when (requestCode) {
//            REQUEST_CODE -> {
//                for (result in grantResults) {
//                    if (result == PackageManager.PERMISSION_DENIED) {
//
//                        binding.showPermissionMsg.visibility = View.VISIBLE
//                        return
//                    }
//                }
//
//                setupSurfaceHolder()
//            }
//        }
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//    }
//
//    private fun setupSurfaceHolder() {
//        binding.startBtn.visibility = View.VISIBLE
//        binding.surfaceView.visibility = View.VISIBLE
//
//        surfaceHolder = binding.surfaceView.holder
//        binding.surfaceView.holder.addCallback(this)
//        setBtnClick()
//    }
//
//    private fun setBtnClick() {
//        binding.startBtn.setOnClickListener { captureImage() }
//    }
//
//    private fun captureImage() {
//        if (camera != null) {
//            camera!!.takePicture(null, null, this)
//        }
//    }
//
//    override fun surfaceCreated(surfaceHolder: SurfaceHolder) {
//        startCamera()
//    }
//
//    private fun startCamera() {
//        camera = Camera.open()
//        camera!!.setDisplayOrientation(90)
//        try {
//            camera!!.setPreviewDisplay(surfaceHolder)
//            camera!!.startPreview()
//        } catch (e: IOException) {
//            e.printStackTrace()
//        }
//
//    }
//
//    override fun surfaceChanged(surfaceHolder: SurfaceHolder, i: Int, i1: Int, i2: Int) {
//        resetCamera()
//    }
//
//    private fun resetCamera() {
//        if (surfaceHolder!!.surface == null) {
//            // Return if preview surface does not exist
//            return
//        }
//
//        // Stop if preview surface is already running.
//        camera!!.stopPreview()
//        try {
//            // Set preview display
//            camera!!.setPreviewDisplay(surfaceHolder)
//        } catch (e: IOException) {
//            e.printStackTrace()
//        }
//
//        // Start the camera preview...
//        camera!!.startPreview()
//    }
//
//    override fun surfaceDestroyed(surfaceHolder: SurfaceHolder) {
//        releaseCamera()
//    }
//
//    private fun releaseCamera() {
//        camera!!.stopPreview()
//        camera!!.release()
//        camera = null
//    }
//
//    override fun onPictureTaken(bytes: ByteArray, camera: Camera) {
//        saveImage(bytes)
//        resetCamera()
//    }
//
//    private fun saveImage(bytes: ByteArray) {
//        val outStream: FileOutputStream
//        try {
//            val fileName = "TUTORIALWING_" + System.currentTimeMillis() + ".jpg"
//            val file = File(
//                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
//                fileName
//            )
//            outStream = FileOutputStream(file)
//            outStream.write(bytes)
//            outStream.close()
//            Toast.makeText(this@MainActivity, "Picture Saved: $fileName", Toast.LENGTH_LONG).show()
//        } catch (e: FileNotFoundException) {
//            e.printStackTrace()
//        } catch (e: IOException) {
//            e.printStackTrace()
//        }
//    }
//
//    companion object {
//        const val REQUEST_CODE = 100
//    }
//}
