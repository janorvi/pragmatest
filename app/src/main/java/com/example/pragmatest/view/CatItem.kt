package com.example.pragmatest.view

import android.widget.TextView
import com.example.pragmatest.R
import com.example.pragmatest.model.Cat
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class CatItem(
    private val cat: Cat
    ): Item<GroupieViewHolder>()
{
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val catBreedTextView: TextView = viewHolder.itemView.findViewById(R.id.bread_name_text_view)
        val catOriginTextView: TextView = viewHolder.itemView.findViewById(R.id.origin_text_view)
        val catIntelligenceTextView: TextView = viewHolder.itemView.findViewById(R.id.intelligence_text_view)
        catBreedTextView.text = cat.breedName
        catOriginTextView.text = cat.origin
        catIntelligenceTextView.text = cat.intelligence.toString()
    }

    override fun getLayout() = R.layout.cat_item
}