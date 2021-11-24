package com.example.caht

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.caht.adapter.ChatAdapter
import com.example.caht.adapter.ChatAdapter.Companion.VIEW_TYPE_MESSAGE_LEFT
import com.example.caht.adapter.ChatAdapter.Companion.VIEW_TYPE_MESSAGE_RIGHT
import com.example.caht.data.Message
import com.example.caht.data.messages
import com.example.caht.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val baseAdapter = ChatAdapter()
    var currentUserId = VIEW_TYPE_MESSAGE_LEFT


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickListener()

        initAdapter()
    }

    private fun initAdapter() {
        binding.recyclerViewContainer.apply {
            adapter = baseAdapter
        }
    }

    private fun initClickListener() = with(binding) {
        firstUser.setOnClickListener { currentUserId = VIEW_TYPE_MESSAGE_LEFT }
        secondUser.setOnClickListener { currentUserId = VIEW_TYPE_MESSAGE_RIGHT }
        send.setOnClickListener { sendMessage(editText.text.toString(), currentUserId) }
    }

    private fun sendMessage(text: String, userId: Int) {
        baseAdapter.sendMessage(text, userId)
    }
}
