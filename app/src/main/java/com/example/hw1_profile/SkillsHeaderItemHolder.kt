package com.example.hw1_profile

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class SkillsHeaderItemHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun bind (idea: Item.SkillsHeaderItem){
        with(itemView){
            idea.run {
                val headerTextView: TextView = findViewById(R.id.headerTextView) as TextView

                headerTextView.text = header

            }
        }
    }
}