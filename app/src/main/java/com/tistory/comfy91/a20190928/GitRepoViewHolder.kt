package com.tistory.comfy91.recyclerview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tistory.comfy91.a20190928.R

class GitRepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val ctnRvITem: View = view.findViewById(R.id.ctnRvItem)
    val txtRvItemName: TextView = view.findViewById(R.id.txtRvItemName)
    val txtRvItemDescription: TextView = view.findViewById(R.id.txtRvItemDescription)
    val txtRvItemLanguage: TextView = view.findViewById(R.id.txtRvItemLanguage)
    val imgRvItemLanguageColor: ImageView = view.findViewById(R.id.imgRvItemLanguageColor)

    // 실제 데이터가 뷰에 담기도록 한다.
    fun bind(data: GitRepoItem){
        txtRvItemName.text = data.name
        txtRvItemDescription.text = data.desc
        txtRvItemLanguage.text = data.language
    }
}