package ua.motionman.recyclerviewlecture.basicadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.caht.data.Message
import com.example.caht.databinding.ItemFirstMessageBinding
import com.example.caht.databinding.ItemSecondMessageBinding

class ChatAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var messages = emptyList<Message>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = messages.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            VIEW_TYPE_MESSAGE_LEFT -> {
                val binding = ItemFirstMessageBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return ViewHolderLeftMessage(binding)
            }
            VIEW_TYPE_MESSAGE_RIGHT -> {
                val binding = ItemSecondMessageBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return ViewHolderRightMessage(binding)
            }
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (messages[position].userId) {
            1 -> VIEW_TYPE_MESSAGE_LEFT
            2 -> VIEW_TYPE_MESSAGE_RIGHT
            else -> throw IllegalArgumentException()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolderLeftMessage -> holder.bind(messages[position])
            is ViewHolderRightMessage -> holder.bind(messages[position])
        }
    }

    class ViewHolderLeftMessage(private val binding: ItemFirstMessageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Message) {
            binding.firstUserMessageTextView.text = item.message
        }
    }

    class ViewHolderRightMessage(private val binding: ItemSecondMessageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Message) {
            binding.secondUserMessageTextView.text = item.message
        }
    }

    companion object {
        const val VIEW_TYPE_MESSAGE_LEFT = 1
        const val VIEW_TYPE_MESSAGE_RIGHT = 2
    }

}