package com.tistory.comfy91.a20190928

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GridViewHolder(view: View): RecyclerView.ViewHolder(view){
    val imgRvItemPhoto: ImageView? = view.findViewById(R.id.imgRvItemProfile)
    val txtRvItemTitle: TextView = view.findViewById(R.id.txtRvItemTitle)
    val txtRvItemStarScore: TextView = view.findViewById(R.id.txtRvItemStarScore)
    val txtRvItemAutor: TextView = view.findViewById(R.id.txtRvItemAuthor)

    fun bind(gridItem: GridItem, context: Context){

        if(!TextUtils.isEmpty(gridItem.img)){
            val resourceId  = context.resources.getIdentifier(gridItem.img,"drawable", context.packageName)
            imgRvItemPhoto?.setImageResource(resourceId)
        }
        else{
            imgRvItemPhoto?.setImageResource(R.mipmap.ic_launcher)
        }
        txtRvItemTitle.text= gridItem.title
        txtRvItemStarScore.text = gridItem.starScore
        txtRvItemAutor.text = gridItem.author

    }


}