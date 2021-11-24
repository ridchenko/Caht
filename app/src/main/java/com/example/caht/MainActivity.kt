package com.example.caht

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.caht.adapter.ChatAdapter
import com.example.caht.adapter.ChatAdapter.Companion.VIEW_TYPE_MESSAGE_LEFT
import com.example.caht.adapter.ChatAdapter.Companion.VIEW_TYPE_MESSAGE_RIGHT
import com.example.caht.data.Message
import com.example.caht.databinding.ActivityMainBinding
import com.example.caht.decorator.MessageDecorator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val baseAdapter = ChatAdapter()
    var currentUserId = VIEW_TYPE_MESSAGE_LEFT
    val messages = mutableListOf<Message>()


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
            addItemDecoration(MessageDecorator(15))
        }
    }

    private fun initClickListener() = with(binding) {
        firstUser.setOnClickListener { currentUserId = VIEW_TYPE_MESSAGE_LEFT
            binding.firstUser.setBackgroundColor(Color.parseColor("#009688"))
            binding.secondUser.setBackgroundColor(Color.parseColor("#2196F3"))
        }
        secondUser.setOnClickListener { currentUserId = VIEW_TYPE_MESSAGE_RIGHT
            binding.secondUser.setBackgroundColor(Color.parseColor("#009688"))
            binding.firstUser.setBackgroundColor(Color.parseColor("#2196F3"))}

        send.setOnClickListener { sendMessage(editText.text.toString(), currentUserId) }
    }

    private fun sendMessage (text: String, userId: Int){
        val newMessage = Message(userId, text)
        messages.add(newMessage)
        baseAdapter.messages = messages
    }
}
