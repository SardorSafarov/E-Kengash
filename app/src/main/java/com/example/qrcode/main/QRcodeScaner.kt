package com.example.qrcode.main

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode
import com.example.ekengash.databinding.ActivityQrcodeScanerBinding
import com.example.log.D
import com.example.qrcode.qrcodeHaqida.QRcodeScanerHaqida

class QRcodeScaner : AppCompatActivity() {
    private lateinit var binding: ActivityQrcodeScanerBinding
    private var codeScanner: CodeScanner? = null
    private var flash = true
    private var PERMISSIONS: Array<String> = arrayOf(
        Manifest.permission.CAMERA
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQrcodeScanerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        codeScanner = CodeScanner(this, binding.scannerView)
        teginma()

    }


    /*===================Teginma============================*/
    private fun teginma() {
        starusBar()
        startScaneer()
        qrcodeHaqida()
        ortgaQaytish()
        flash()
        chackPerimition()
    }

    private fun qrcodeHaqida() {
        binding.qrCodeScanerHaqida.setOnClickListener {
            startActivity(Intent(this, QRcodeScanerHaqida::class.java))
        }
    }

    fun startScaneer() {
        codeScanner?.apply {
            camera = CodeScanner.CAMERA_BACK
            formats = CodeScanner.ALL_FORMATS
            autoFocusMode = AutoFocusMode.SAFE
            scanMode = ScanMode.SINGLE
            isAutoFocusEnabled = true
            decodeCallback = DecodeCallback { result ->
                runOnUiThread {
                    val vibrator = getSystemService(VIBRATOR_SERVICE) as Vibrator
                    if (Build.VERSION.SDK_INT >= 26) {
                        vibrator.vibrate(
                            VibrationEffect.createOneShot(
                                500,
                                VibrationEffect.DEFAULT_AMPLITUDE
                            )
                        )
                    } else {
                        vibrator.vibrate(500)
                    }

                    Toast.makeText(this@QRcodeScaner, "${result.text}", Toast.LENGTH_SHORT).show()
                }
                errorCallback = ErrorCallback {
                    runOnUiThread {
                        D.d("QRcodeScaner codeScanner.errorCallback ")
                    }
                }
            }
        }

        binding.scannerView.setOnClickListener {
            codeScanner?.startPreview()
        }
    }


    private fun starusBar() {
        window.statusBarColor = Color.WHITE
    }

    private fun ortgaQaytish() {
        binding.orqagaQaytish.setOnClickListener {
            finish()
        }
    }

    private fun flash() {
        binding.flashButton.setOnClickListener {
            codeScanner?.apply {
                if (flash) {
                    D.d("1")
                    this.isFlashEnabled = true
                    flash = false

                } else {
                    D.d("2")
                    this.isFlashEnabled = false
                    flash = true
                }
            }

        }
    }

    override fun onResume() {
        super.onResume()
        codeScanner?.startPreview()
    }

    override fun onPause() {
        codeScanner?.releaseResources()
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        codeScanner = null
    }

    /*---------------Ruxsat berish-------------------*/
    private fun chackPerimition() {
        if (!hasPermissions(this, *PERMISSIONS)) {

            ActivityCompat.requestPermissions(this, PERMISSIONS, 1);
        }
    }

    private fun hasPermissions(context: Context?, vararg PERMISSIONS: String): Boolean {
        if (context != null && PERMISSIONS != null) {
            for (permission in PERMISSIONS) {
                if (ActivityCompat.checkSelfPermission(
                        context,
                        permission
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    return false
                }
            }
        }
        return true
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray,
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            }
        }
    }
}