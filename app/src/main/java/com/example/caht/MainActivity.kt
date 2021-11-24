package com.example.caht

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.caht.ChatAdapter.Companion.VIEW_TYPE_MESSAGE_LEFT
import com.example.caht.data.Message
import com.example.caht.data.messages
import com.example.caht.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val baseAdapter = ChatAdapter()
    val currentUserId = VIEW_TYPE_MESSAGE_LEFT
    val messageList = mutableListOf<Message>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initAdapter()
        baseAdapter.messages = messages
    }

    private fun initAdapter() {
        binding.recyclerViewContainer.apply {
            adapter = baseAdapter
        }
    }
}
