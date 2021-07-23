package com.example.hw1_profile

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class IdeaItemHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun bind (idea: Item.IdeaItem){
        with(itemView){
            idea.run {
                val nameTextView: TextView = findViewById(R.id.headerTextView) as TextView
                val timeTextView: TextView = findViewById(R.id.textTextView) as TextView

                nameTextView.text = header
                timeTextView.text = text

            }
        }
    }
}