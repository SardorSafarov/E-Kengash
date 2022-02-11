package com.example.ekengash.servislar.aviachipta.bootomsheet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ekengash.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class AviaQayerdan : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_avia_qayerdan, container, false)
    }

}