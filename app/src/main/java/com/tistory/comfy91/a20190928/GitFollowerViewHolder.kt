package com.tistory.comfy91.a20190928

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class GitFollowerViewHolder(view: View): RecyclerView.ViewHolder(view){

    val imgRvItemProfile: ImageView = view.findViewById(R.id.imgRvItemProfile)
    val txtRvItemId: TextView = view.findViewById(R.id.txtRvItemId)
    val txtRvItemName: TextView = view.findViewById(R.id.txtRvItemName)

    fun bind(data: GitFollowerItem){
        txtRvItemId.text = data.id
        txtRvItemName.text = data.name
    }

}