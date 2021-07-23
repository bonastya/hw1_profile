package com.example.hw1_profile

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView


class NameItemHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun bind (profile: Item.NameItem){
        with(itemView){
            profile.run {
                val nameTextView: TextView = findViewById(R.id.nameTextView) as TextView
                val timeTextView: TextView = findViewById(R.id.timeTextView) as TextView
                val button: Button = findViewById(R.id.githubbutton) as Button

                nameTextView.text = name
                timeTextView.text = time
                button.setOnClickListener {
                    try {
                        val browserIntent =
                            Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/bonastya"))
                        startActivity(context, browserIntent, null)
                    } catch (e: ActivityNotFoundException) {
                        Toast.makeText(context, "Проверьте интернет соединение", Toast.LENGTH_LONG)
                            .show()
                        e.printStackTrace()
                    }
                }

            }
        }
    }
}