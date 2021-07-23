package com.example.hw1_profile


import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class SkillViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun bind (skill: Skill){
        with(itemView){
            skill.run {
                val skilltextView: TextView = findViewById(R.id.skillTextView) as TextView
                val timetextView: TextView = findViewById(R.id.timeTextView) as TextView

                skilltextView.text = name
                timetextView.text = time

            }
        }
    }
}




/*

abstract class BaseViewHolder<T> (itemView: View): RecyclerView.ViewHolder(itemView){abstract fun bind(_object:T)}

class SkillViewHolder (itemView: View): BaseViewHolder<Skill>(itemView){
    override fun bind (skill: Skill){
        with(itemView){
            skill.run {
                val skilltextView: TextView = findViewById(R.id.skillTextView) as TextView
                val timetextView: TextView = findViewById(R.id.timeTextView) as TextView

                skilltextView.text = name
                timetextView.text = time
                //avatarImageView.setImageResource(imagesList[avatarNumber])

            }
        }
    }
}
*/

/*class SkillViewHolder(itemView: View): BaseViewHolder<Skill>(itemView) {
    var skilltextView: TextView
    var timetextView: TextView

    init {
        skilltextView = itemView.findViewById(R.id.skillTextView) as TextView
        timetextView = itemView.findViewById(R.id.timeTextView) as TextView
    }

    override fun bind(skill: Skill) {
        with(itemView){
            skill.run {
                val skilltextView: TextView = findViewById(R.id.skillTextView) as TextView
                val timetextView: TextView = findViewById(R.id.timeTextView) as TextView

                skilltextView.text = name
                timetextView.text = time
                //avatarImageView.setImageResource(imagesList[avatarNumber])

            }
        }
    }
}*/
/*

class NameRowViewHolder (itemView: View): BaseViewHolder<NameRowType>(itemView){
    override fun bind (namerow: NameRowType){
        with(itemView){
            namerow.run {
                val nametextView: TextView = findViewById(R.id.nameTextView) as TextView
                val timetextView: TextView = findViewById(R.id.timeTextView) as TextView

                nametextView.text = name
                timetextView.text = time
                //avatarImageView.setImageResource(imagesList[avatarNumber])

            }
        }
    }
}

*/
