package com.example.hw1_profile

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.lang.IllegalArgumentException

class MainAdapter(var items:List<Item>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType){
            VIEW_TYPE_NAMECARD->{
                val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_namecard, parent, false)
                return NameItemHolder(itemView)
            }
            VIEW_TYPE_IDEA->{
                val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_idea, parent, false)
                return IdeaItemHolder(itemView)
            }
            VIEW_TYPE_SKILLS_HEADER->{
                val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_skill_header, parent, false)
                return SkillsHeaderItemHolder(itemView)
            }
            VIEW_TYPE_SCILLS->{
                val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_namecard, parent, false)
                return SkillsItemHolder(itemView)
            }
            else ->{
                IllegalArgumentException("")
                val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_namecard, parent, false)
                return NameItemHolder(itemView)
            }


        }


    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(val item = items[position]){
            is Item.NameItem ->
                (holder as NameItemHolder).bind(item)
            is Item.IdeaItem ->
                (holder as IdeaItemHolder).bind(item)
            is Item.SkillsHeaderItem ->
                (holder as SkillsHeaderItemHolder).bind(item)
            /*is Item.SkillsItem ->
                (holder as SkillsItemHolder).bind(item)*/
        }
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        when(items[position]){
            is Item.NameItem ->
                return VIEW_TYPE_NAMECARD
            is Item.IdeaItem ->
                return VIEW_TYPE_IDEA
            is Item.SkillsHeaderItem ->
                return VIEW_TYPE_SKILLS_HEADER
            is Item.SkillsItem ->
                return VIEW_TYPE_SCILLS
            else ->
                return VIEW_TYPE_SCILLS

        }
    }

    companion object {
        const val VIEW_TYPE_NAMECARD = 1
        const val VIEW_TYPE_IDEA = 2
        const val VIEW_TYPE_SKILLS_HEADER = 3
        const val VIEW_TYPE_SCILLS = 4
    }


}