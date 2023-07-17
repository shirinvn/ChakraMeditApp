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
            playSong(1)
        }
        binding.chakra2.setOnClickListener {
            playSong(2)
        }
        binding.chakra3.setOnClickListener {
            playSong(3)
        }
        binding.chakra4.setOnClickListener {
            playSong(4)
        }
        binding.chakra5.setOnClickListener {
            playSong(5)
        }
        binding.chakra6.setOnClickListener {
            playSong(6)
        }
        binding.chakra7.setOnClickListener {
            playSong(7)
        }


    }

//    fun playSound() {
//        if (!isPlaying) {
//            mediaPlayer.start()
//            isPlaying = true
//        } else {
//            mediaPlayer.pause()
//            isPlaying = false
//        }
//    }

    fun playSong(songId: Int) {
        val resourceId = getSongResourceId(songId)
        if (resourceId != 0 && !isPlaying) {
            mediaPlayer?.release()
            mediaPlayer = MediaPlayer.create(requireContext(), resourceId)
            mediaPlayer?.start()
            isPlaying =true

        }else{

            mediaPlayer.stop()
            isPlaying=false

        }

    }

    fun getSongResourceId(songId: Int): Int {
        return when (songId) {
            1 -> com.example.chakrameditapp.R.raw.divar
            2 -> com.example.chakrameditapp.R.raw.audio
            3 -> com.example.chakrameditapp.R.raw.divar
            4 -> com.example.chakrameditapp.R.raw.audio
            5 -> com.example.chakrameditapp.R.raw.divar
            6 -> com.example.chakrameditapp.R.raw.audio
            7 -> com.example.chakrameditapp.R.raw.divar
            else -> 0
        }
    }


}