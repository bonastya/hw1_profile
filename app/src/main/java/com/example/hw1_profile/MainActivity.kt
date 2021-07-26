package com.example.hw1_profile

import android.os.Bundle
import android.widget.CheckBox
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    var items:ArrayList<Item> = ArrayList<Item>()

    var filterlist:ArrayList<String> = arrayListOf("1 год", "2 года","3 года")
    var filter:Filter=Filter(filterlist)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }

        setContentView(R.layout.activity_main)




        filterlist.clear()
        println("aaa "+filterlist)
        println("aaa "+intent.extras)

        val extras = intent.extras
        if (extras != null){

            if(extras.getSerializable("checkedFilters") != null){
                filter = extras.getSerializable("checkedFilters") as  Filter
                println("aaa "+filter.filterskills)
            }else{


            }

        }

        else{


        }





        fillList()

        val mainAdapter= MainAdapter(items)
        val personlist: RecyclerView = findViewById(R.id.ProfileRecyclerView) as RecyclerView

        with(personlist){
            this.layoutManager= LinearLayoutManager(context)
            this.adapter = mainAdapter
            this.setHasFixedSize(true)
        }

    }

/*    var skillList = mutableListOf<Skill>()

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


    }*/

    private fun fillList(){
        items.add(0,Item.NameItem("Анастасия Богодухова", "3 курс"))
        val ideatext = "Приложение позволяющее найти единомышленников по интересам для обмена навыками и опытом в желаеммых сферах.\n" +
                "При входе в приложение пользователь заполняет анкету о себе, описывая те навыки, которыми он обладает, и те, которые хотел бы приобрести.\n" +
                "Исходя из этой информации алгоритмы приложения находят наиболее подходящих людей для обмена навыками.\n" +
                "Предлагается расширенный поиск, просматривание анкет других пользователей и общение в чате с теми, чьи анкеты понравились :)"
        items.add(1,Item.IdeaItem("Идея проекта", ideatext))
        items.add(2,Item.SkillsHeaderItem("Навыки", filter.filterskills.size == 0 || filter.filterskills.size == 3))

        var skillList = mutableListOf<Skill>()
        var filterSkillList = mutableListOf<Skill>()
        skillList.add(Skill("C","1 год"))
        skillList.add(Skill("C++","3 года"))
        skillList.add(Skill("C#","2 года"))
        skillList.add(Skill("JS","2 года"))
        skillList.add(Skill("SQL","3 года"))
        skillList.add(Skill("PHP","1 год"))
        skillList.add(Skill("Kotlin","1 год"))

        filterSkillList.clear()

        println("aaa b1 "+filterSkillList)
        println("aaa b2 "+filter.filterskills)


        if(filter.filterskills.size == 0 || filter.filterskills.size == 3){
            items.add(3,Item.SkillsItem(skillList))

        }
        else{
            for(i in skillList){
                for (j in filter.filterskills){
                    if ( i.time.contains(j, ignoreCase = true)){
                        filterSkillList.add(i)
                        continue
                    }

                }

            }
            println("aaa b3 "+filterSkillList)

            items.add(3,Item.SkillsItem(filterSkillList))
        }




    }

/*    fun onClickFilter(view: View) {
        val intent = Intent(this@MainActivity, FilterActivity::class.java)
        startActivity(intent)
    }*/






}
