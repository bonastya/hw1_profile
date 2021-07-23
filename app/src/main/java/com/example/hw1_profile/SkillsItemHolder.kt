package com.example.hw1_profile

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView




class SkillsItemHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun bind (idea: Item.SkillsItem){
        with(itemView){
            idea.run {
                val recyclerView: RecyclerView = findViewById(R.id.skillsRecyclerView) as RecyclerView

                val SkillsAdapter= SkillsAdapter(idea.skills)

                with(recyclerView){
                    this.layoutManager= LinearLayoutManager(context)
                    this.adapter = SkillsAdapter
                    this.setHasFixedSize(true)
                }

            }
        }
    }
}