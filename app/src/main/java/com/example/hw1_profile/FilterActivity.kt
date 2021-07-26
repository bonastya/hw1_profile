package com.example.hw1_profile

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FilterActivity : AppCompatActivity() {

    var items:ArrayList<Item> = ArrayList<Item>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }

        setContentView(R.layout.activity_filter)

        val checkBoxAll: CheckBox = findViewById(R.id.checkBoxAll) as CheckBox
        val checkBox1: CheckBox = findViewById(R.id.checkBox1) as CheckBox
        val checkBox2: CheckBox = findViewById(R.id.checkBox2) as CheckBox
        val checkBox3: CheckBox = findViewById(R.id.checkBox3) as CheckBox
        val buttonOk: Button = findViewById(R.id.buttonOk) as Button

        var filterList:ArrayList<String> = ArrayList<String>()


        checkBoxAll.setOnCheckedChangeListener { checkBoxAll, isChecked ->
            if(isChecked){
                checkBox1.isChecked = true
                checkBox2.isChecked = true
                checkBox3.isChecked = true
            }
            else{
                if(checkBox2.isChecked && checkBox3.isChecked && checkBox1.isChecked){
                    checkBox1.isChecked = false
                    checkBox2.isChecked = false
                    checkBox3.isChecked = false
                }

            }
        }
        checkBox1.setOnCheckedChangeListener { checkBox1, isChecked ->
            if(!isChecked){
                checkBoxAll.isChecked = false
            }
            else{
                if(checkBox2.isChecked && checkBox3.isChecked)
                    checkBoxAll.isChecked = true
            }
        }
        checkBox2.setOnCheckedChangeListener { checkBox2, isChecked ->
            if(!isChecked){
                checkBoxAll.isChecked = false
            }
            else{
                if(checkBox1.isChecked && checkBox3.isChecked)
                    checkBoxAll.isChecked = true
            }
        }
        checkBox3.setOnCheckedChangeListener { checkBox3, isChecked ->
            if(!isChecked){
                checkBoxAll.isChecked = false
            }
            else{
                if(checkBox2.isChecked && checkBox1.isChecked)
                    checkBoxAll.isChecked = true
            }
        }



        buttonOk.setOnClickListener {
            filterList.clear()
            if(checkBox1.isChecked)
                filterList.add("1 год")
            if(checkBox2.isChecked)
                filterList.add("2 года")
            if(checkBox3.isChecked)
                filterList.add("3 года")
            val filter:Filter = Filter(filterList)

            val intent = Intent(this, MainActivity::class.java)

            intent.putExtra("checkedFilters", filter)
            startActivity(intent)


        }



    }


}
