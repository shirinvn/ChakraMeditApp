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
    private lateinit var mediaPlayer: MediaPlayer
    private var isPlaying = false


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
        mediaPlayer = (activity as MainActivity).getMediaPlayer()
        binding.chakra1.setOnClickListener {
           playSound()
        }
        binding.chakra2.setOnClickListener {
           playSound()
        }
        binding.chakra3.setOnClickListener {
           playSound()
        }
        binding.chakra4.setOnClickListener {
           playSound()
        }
        binding.chakra5.setOnClickListener {
           playSound()
        }
        binding.chakra6.setOnClickListener {
           playSound()
        }
        binding.chakra7.setOnClickListener {
           playSound()
        }


    }
    fun playSound() {
        if (!isPlaying) {
            mediaPlayer.start()
            isPlaying = true
        } else {
            mediaPlayer.pause()
            isPlaying = false
        }
    }




}