package com.example.chakrameditapp

import android.R
import android.R.attr.data
import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.chakrameditapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var mMediaPlayer: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.chakra1.setOnClickListener {
            playSound()
        }
    }

    private fun playSound() {
        if (mMediaPlayer == null) {
            mMediaPlayer = MediaPlayer.create(requireContext(), R.raw.audio)
            mMediaPlayer?.isLooping = true
            mMediaPlayer?.start()
        } else {
            mMediaPlayer?.start()
        }
    }

    override fun onPause() {
        super.onPause()
        pauseSound()
    }

    private fun pauseSound() {
        if (mMediaPlayer?.isPlaying == true) {
            mMediaPlayer?.pause()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        stopSound()
    }

    private fun stopSound() {
        mMediaPlayer?.stop()
        mMediaPlayer?.reset()
        mMediaPlayer?.release()
        mMediaPlayer = null
    }
}