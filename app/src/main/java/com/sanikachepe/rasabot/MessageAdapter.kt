package com.sanikachepe.rasabot

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MessageAdapter(var context:Context, var messageList:MutableList<MessageClass>):RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {
    private val USER_LAYOUT = 0
    private val BOT_LAYOUT = 1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        if(viewType.equals(USER_LAYOUT)){
            val view = LayoutInflater.from(context).inflate(R.layout.user_message_box,parent,false)
            return MessageViewHolder(view)
        }else{
            val view = LayoutInflater.from(context).inflate(R.layout.bot_message_box,parent,false)
            return MessageViewHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val currentMessage = messageList[position]
        if(currentMessage.sender.equals(0)) {
            holder.message_view.setText(currentMessage.message)

        } else if(currentMessage.sender.equals(1)) {
            holder.message_view.setText(currentMessage.message)
        }
    }

    override fun getItemViewType(position: Int): Int {
        super.getItemViewType(position)
        val view = messageList[position]
        if(view.sender.equals(USER_LAYOUT)) {
            return USER_LAYOUT
        }else{
            return BOT_LAYOUT
        }
    }

    class MessageViewHolder(view:View):RecyclerView.ViewHolder(view){
        val message_view=view.findViewById<TextView>(R.id.message_tv)
        val time_view=view.findViewById<TextView>(R.id.time_tv)
    }

}