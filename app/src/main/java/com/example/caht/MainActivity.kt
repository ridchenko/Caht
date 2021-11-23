package com.example.caht

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import com.example.caht.data.messages
import com.example.caht.databinding.ActivityMainBinding
import ua.motionman.recyclerviewlecture.basicadapter.ChatAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val baseAdapter = ChatAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initAdapter()
        baseAdapter.messages = messages
    }

    fun initAdapter() {
        binding.recyclerViewContainer.apply {
            adapter = baseAdapter
        }
    }
}