package com.example.hw1_profile

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class NameItemHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun bind (profile: Item.NameItem){
        with(itemView){
            profile.run {
                val nameTextView: TextView = findViewById(R.id.nameTextView) as TextView
                val timeTextView: TextView = findViewById(R.id.timeTextView) as TextView

                nameTextView.text = name
                timeTextView.text = time

            }
        }
    }
}