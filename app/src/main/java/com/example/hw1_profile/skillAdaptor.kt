package com.example.hw1_profile

import android.content.ClipData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_skill.*;
import kotlinx.android.synthetic.main.item_namecard.*;


class skillAdaptor: RecyclerView.Adapter<SkillViewHolder>(){

    var personList = mutableListOf<Skill>()
    var allPersonList = mutableListOf<Skill>()

    fun setList(personlist: MutableList<Skill>){
        personList.clear()
        for (i in personlist){
            personList.add(i)}
        notifyDataSetChanged()
    }

    fun resetList(){
        personList.clear()
        for (i in allPersonList){
            personList.add(i)}
        notifyDataSetChanged()
    }

    fun addSkill(person:Skill){
        allPersonList.add(person)
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_skill, parent, false)
        return SkillViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SkillViewHolder, position: Int) {
        holder.bind(personList[position])
    }

    override fun getItemCount()= personList.size



}





/*

class MultipleTypesAdapter (list: List<out RowType>, context: Context):RecyclerView.Adapter<BaseViewHolder<*>>()  {

    private val dataSet: List<RowType> = TODO()

*/
/*    override fun getItemViewType(position: Int): Int {
        return if (dataSet[position] is Skill) {
            RowType.SKILL_ROW_TYPE
        } else if (dataSet[position] is NameRowType) {
            RowType.NAME_ROW_TYPE
        } else if (dataSet[position] is IdeaRowType) {
            RowType.IDEA_ROW_TYPE
        }else if (dataSet[position] is SkillsHeaderRowType) {
            RowType.SKILLS_HEADER_ROW_TYPE
        } else {
            -1
        }
    }*//*

*/
/*    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            ItemsAdapter.VIEW_TYPE_HEADER ->
                ItemsAdapter.ViewHolderHeader(
                    ItemHeaderBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )

            ItemsAdapter.VIEW_TYPE_TEXT ->
                ItemsAdapter.ViewHolderText(
                    ItemTextBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )

            else ->
                throw IllegalArgumentException("")
        }*//*


*/
/*    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == RowType.SKILL_ROW_TYPE) {
            val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_skill, parent, false)
            return SkillViewHolder(itemView)

        } else if (viewType == RowType.NAME_ROW_TYPE) {
            val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_skill, parent, false)
            return SkillViewHolder(itemView)
        }  else {
            null
        }
    }*//*


    val nametextView: TextView = findViewById(R.id.nameTextView) as TextView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return if (viewType == RowType.SKILL_ROW_TYPE) {
            val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_skill, parent, false)
            return SkillViewHolder(itemView)

        } else if (viewType == RowType.NAME_ROW_TYPE) {
            val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_namecard, parent, false)
            return SkillViewHolder(itemView)
        }  else {
            val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_skill, parent, false)
            return SkillViewHolder(itemView)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {

        if (holder is SkillViewHolder) {
            holder.skilltextView
                .setText((dataSet[position] as Skill).name)
            holder.timetextView
                .setText((dataSet[position] as Skill).time)
        } else if (holder is TextViewHolder) {
            val skilltextView: TextView = findViewById(R.id.skillTextView) as TextView
            val timetextView: TextView = findViewById(R.id.timeTextView) as TextView
            holder.skilltextView
                .setText((dataSet[position] as TextRowType).getHeader())
            holder.textView1
                .setText((dataSet[position] as TextRowType).getText())
        }
    }
*/
/*    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (holder is ButtonViewHolder) {
            holder.button
                .setOnClickListener((dataSet[position] as ButtonRowType).getOnClickListener())
        } else if (holder is ImageViewHolder) {
            holder.textView2
                .setText((dataSet[position] as ImageRowType).getText())
        } else if (holder is TextViewHolder) {
            holder.headerTextView
                .setText((dataSet[position] as TextRowType).getHeader())
            holder.textView1
                .setText((dataSet[position] as TextRowType).getText())
        }
    }*//*


    override fun getItemCount(): Int {
        return dataSet.size
    }




    class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var headerTextView: TextView
        var textView1: TextView

        init {
            headerTextView = itemView.findViewById<View>(R.id.header) as TextView
            textView1 = itemView.findViewById<View>(R.id.text) as TextView
        }
    }




}


















*/
/*


class ItemsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var items: List<ClipData.Item> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            VIEW_TYPE_HEADER ->
                ViewHolderHeader(ItemHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false))

            VIEW_TYPE_TEXT ->
                ViewHolderText(ItemTextBinding.inflate(LayoutInflater.from(parent.context), parent, false))

            else ->
                throw IllegalArgumentException("")
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is ClipData.Item.Header ->
                (holder as? ViewHolderHeader)?.onBind(item)

            is ClipData.Item.WithText ->
                (holder as? ViewHolderText)?.onBind(item)
        }
    }

    override fun getItemViewType(position: Int): Int =
        when (items[position]) {
            is ClipData.Item.Header ->
                VIEW_TYPE_HEADER

            is ClipData.Item.WithText ->
                VIEW_TYPE_TEXT
        }

    override fun getItemCount(): Int =
        items.size

    class ViewHolderHeader(
        private val viewBinding: ItemHeaderBinding
    ) : RecyclerView.ViewHolder(viewBinding.root) {
        fun onBind(item: ClipData.Item.Header) {
            viewBinding.header.text = item.title
        }
    }

    class ViewHolderText(
        private val viewBinding: ItemTextBinding
    ) : RecyclerView.ViewHolder(viewBinding.root) {
        fun onBind(item: ClipData.Item.WithText) {
            viewBinding.text.text = item.text
        }
    }

    companion object {
        const val VIEW_TYPE_HEADER = 1
        const val VIEW_TYPE_TEXT = 2
    }
}



*//*






class skillAdaptor: RecyclerView.Adapter<SkillViewHolder>(){

    var skillList = mutableListOf<Skill>()
    var allskillList = mutableListOf<Skill>()

    fun setList(skillList1: MutableList<Skill>){
        skillList.clear()
        for (i in skillList1){
            skillList.add(i)}
        notifyDataSetChanged()
    }

    fun resetList(){
        skillList.clear()
        for (i in allskillList){
            skillList.add(i)}
        notifyDataSetChanged()
    }

    fun addSkill(person:Skill){
        allskillList.add(person)
        notifyDataSetChanged()
    }



override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_skill, parent, false)
        return SkillViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: MultipleTypesAdapter.SkillViewHolder, position: Int) {
        holder.bind(skillList[position])
    }

    override fun getItemCount()= skillList.size


//метод, в коем вы должны в зависимости от позиции элемента возвращать
//её тип в виде числа, кое потом используется в onCreateViewHolder для загрузки разметки
//и в onBindViewHolder для наполнения её данными

    override fun getItemViewType(position:Int): Int {
        if (position == 0)
        {
            return 0
        }
        else
        {
            return 1
        }
    }

    */
/*override fun   onCreateViewHolder( parent:ViewGroup,  viewType:Int):RecyclerView.ViewHolder
    {
         val vh:RecyclerView.ViewHolder
        val  itemLayoutView:View;

        //загружаем разметку в зависимости от типа и возвращаем
        //нужный холдер
        when (viewType)
        {
            0 ->{
                val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_skill, parent, false)
                return SkillViewHolder(itemView)
            }

            1->{
                val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_namecard, parent, false)
                return SkillViewHolder(itemView)
            }

        }

        return vh;
    }*//*





}




*/
