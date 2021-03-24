package com.cursoandroid.appkotlin.ui

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cursoandroid.appkotlin.R
import com.cursoandroid.appkotlin.databinding.FragmentSplashScreenBinding


class SplashScreenFragment : Fragment(R.layout.fragment_splash_screen) {

    private lateinit var binding: FragmentSplashScreenBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var path:String = "android.resource://com.cursoandroid.appkotlin/"
        var uri = Uri.parse(path)
        binding = FragmentSplashScreenBinding.bind(view)

        binding.videoSplash.setVideoURI(uri)
        binding.videoSplash.start()

        binding.videoSplash.setOnPreparedListener {
            it.isLooping
        }

    }

    override fun onResume() {
        binding.videoSplash.resume()
        super.onResume()

    }

    override fun onPause() {
        binding.videoSplash.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        binding.videoSplash.stopPlayback()
        super.onDestroy()
    }
}