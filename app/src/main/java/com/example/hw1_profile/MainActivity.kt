package com.example.hw1_profile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var items:ArrayList<Item> = ArrayList<Item>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }

        setContentView(R.layout.activity_main)

        fillList()

        val mainAdapter= MainAdapter(items)
        val personlist: RecyclerView = findViewById(R.id.ProfileRecyclerView) as RecyclerView

        with(personlist){
            this.layoutManager= LinearLayoutManager(context)
            this.adapter = mainAdapter
            this.setHasFixedSize(true)
        }

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
        val ideatext = "Приложение позволяющее найти единомышленников по интересам для обмена навыками и опытом в желаеммых сферах.\n" +
                "При входе в приложение пользователь заполняет анкету о себе, описывая те навыки, которыми он обладает, и те, которые хотел бы приобрести.\n" +
                "Исходя из этой информации алгоритмы приложения находят наиболее подходящих людей для обмена навыками.\n" +
                "Предлагается расширенный поиск, просматривание анкет других пользователей и общение в чате с теми, чьи анкеты понравились :)"
        items.add(1,Item.IdeaItem("Идея проекта", ideatext))
        items.add(2,Item.SkillsHeaderItem("Навыки"))

        var skillList = mutableListOf<Skill>()
        skillList.add(Skill("C","1 год"))
        skillList.add(Skill("C++","3 года"))
        skillList.add(Skill("C#","2 года"))
        skillList.add(Skill("JS","2 года"))
        skillList.add(Skill("SQL","2,5 года"))
        skillList.add(Skill("PHP","1 год"))
        skillList.add(Skill("Kotlin","1 год"))

        items.add(3,Item.SkillsItem(skillList))

    }



}
