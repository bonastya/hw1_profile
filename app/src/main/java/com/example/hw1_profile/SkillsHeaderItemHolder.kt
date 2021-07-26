package com.example.hw1_profile

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView


class SkillsHeaderItemHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun bind (idea: Item.SkillsHeaderItem){
        with(itemView){
            idea.run {
                val headerTextView: TextView = findViewById(R.id.headerTextView) as TextView
                val imgFilter: ImageView = findViewById(R.id.imageViewFilter) as ImageView

                headerTextView.text = header

                if(ifSetFilter)
                    imgFilter.setImageResource(R.drawable.ic_filter)

                else
                    imgFilter.setImageResource(R.drawable.filter)

                imgFilter.setOnClickListener {
                    try {
                        val browserIntent =
                            Intent(context, FilterActivity::class.java)
                        ContextCompat.startActivity(context, browserIntent, null)
                    } catch (e: ActivityNotFoundException) {
                        Toast.makeText(context, "Неправильный переход между экранами", Toast.LENGTH_LONG)
                            .show()
                        e.printStackTrace()
                    }
                }




            }
        }
    }

}