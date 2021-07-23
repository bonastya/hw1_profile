package com.example.hw1_profile

import android.content.Context
import android.os.Parcelable
import android.view.View
import android.widget.Toast
import kotlinx.android.parcel.Parcelize

@Parcelize
class Skill(val name: String, val time: String): Parcelable {
}
@Parcelize
class Profile(val name: String, val time: String): Parcelable {
}

data class IdeaRowType(val header: String, val text: String): RowType {
}

data class SkillsHeaderRowType(val header: String): RowType {
}
interface RowType {
    companion object {
        const val SKILL_ROW_TYPE = 0
        const val NAME_ROW_TYPE = 1
        const val IDEA_ROW_TYPE = 2
        const val SKILLS_HEADER_ROW_TYPE = 3
    }
}


/*
sealed interface Item : Parcelable {
    @Parcelize
    data class Header(val title: String) : Item
    @Parcelize
    data class WithText(val text: String) : Item
}*/
