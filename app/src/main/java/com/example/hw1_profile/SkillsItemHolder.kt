package com.example.hw1_profile

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class SkillsItemHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun bind (idea: Item.SkillsItem){
        with(itemView){
            idea.run {
                val nameTextView: TextView = findViewById(R.id.nameTextView) as TextView
                val timeTextView: TextView = findViewById(R.id.timeTextView) as TextView

                /*nameTextView.text = header
                timeTextView.text = text*/

            }
        }
    }
}