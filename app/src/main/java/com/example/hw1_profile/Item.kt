package com.example.hw1_profile

interface Item {

    data class SkillsItem(val skills: List<Skill>): Item {}
    data class NameItem(val name: String, val time: String): Item {}
    data class IdeaItem(val header: String, val text: String): Item {}
    data class SkillsHeaderItem(val header: String, val ifSetFilter: Boolean): Item {}

}