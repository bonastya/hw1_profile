package com.example.hw1_profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var items:ArrayList<Item> = ArrayList<Item>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fillList()

        val mainAdapter= MainAdapter(items)
        val personlist: RecyclerView = findViewById(R.id.ProfileRecyclerView) as RecyclerView

        with(personlist){
            this.layoutManager= LinearLayoutManager(context)
            this.adapter = mainAdapter
            this.setHasFixedSize(true)
        }




        //initRecyclerView()

    }

    var skillList = mutableListOf<Skill>()

    private fun initRecyclerView(){
        val skilladaptor= skillAdaptor()

        val personlist: RecyclerView = findViewById(R.id.ProfileRecyclerView) as RecyclerView

        with(personlist){
            this.layoutManager= LinearLayoutManager(context)
            this.adapter = skilladaptor
            this.setHasFixedSize(true)
        }


        for(i in 1..20) {
            skilladaptor.addSkill(
                Skill(
                    "Kotlin",
                    "2 года"
                )
            )
        }
        skilladaptor.resetList()


    }

    private fun fillList(){
        items.add(0,Item.NameItem("Анастасия Богодухова", "3 курс"))
        items.add(1,Item.IdeaItem("Идея проекта", "Проект позволяющий найти единомышленников по интересам для обмена навыками и опытом в желаеммых сферах"))
        items.add(2,Item.SkillsHeaderItem("Навыки"))

        var skillList = mutableListOf<Skill>()
        skillList.add(Skill("C++","3 года"))
        skillList.add(Skill("C#","2 года"))
        skillList.add(Skill("JS","2 года"))

        //items.add(3,Item.SkillsItem(skillList))

    }



}
