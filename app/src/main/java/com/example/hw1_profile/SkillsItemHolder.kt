package com.example.hw1_profile

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.Button
import android.widget.EditText
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

/*    fun filter(filter: String) {
        SkillsAdapter.resetList()
        personFilterList.clear()

        val text: EditText = findViewById(R.id.editTextSearch) as EditText

        if( personAdaptor.personList.size!=0){
            for(i in personAdaptor.personList){
                if (i.name.contains(text.text, ignoreCase = true) or i.description.contains(text.text, ignoreCase = true))
                    personFilterList.add(i)
                println("iii "+i.name+" "+text.text+" "+i.name.contains(text.text, ignoreCase = true))
            }
            personAdaptor.setList(personFilterList)
        }


    }*/
}