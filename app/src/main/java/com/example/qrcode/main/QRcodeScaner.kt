package com.example.qrcode.main

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
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
    private lateinit var codeScanner: CodeScanner
    private var flash = true

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
    }

    private fun qrcodeHaqida() {
        binding.qrCodeScanerHaqida.setOnClickListener {
            startActivity(Intent(this, QRcodeScanerHaqida::class.java))
        }
    }

    fun startScaneer() {
        codeScanner.camera = CodeScanner.CAMERA_BACK
        codeScanner.formats = CodeScanner.ALL_FORMATS
        codeScanner.autoFocusMode = AutoFocusMode.SAFE
        codeScanner.scanMode = ScanMode.SINGLE
        codeScanner.isAutoFocusEnabled = true
        codeScanner.decodeCallback = DecodeCallback { result ->
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

                D.d(result.text)

            }
        }
        codeScanner.errorCallback = ErrorCallback {
            runOnUiThread {
                D.d("QRcodeScaner codeScanner.errorCallback ")
            }
        }
        binding.scannerView.setOnClickListener {
            codeScanner.startPreview()
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
            if (flash) {
                D.d("1")
                codeScanner.isFlashEnabled = true
                flash = false

            } else {
                D.d("2")
                codeScanner.isFlashEnabled = false
                flash = true
            }
        }
    }
    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }
}