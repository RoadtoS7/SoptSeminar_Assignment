package com.tistory.comfy91.a20190928.feature.gitfollwer

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tistory.comfy91.a20190928.R
import com.tistory.comfy91.a20190928.data.GitFollowerItem
import com.tistory.comfy91.a20190928.feature.gitrepo.GitRepoListActivity

class GitFollowerViewHolder(view: View): RecyclerView.ViewHolder(view){

    val imgRvItemProfile: ImageView = view.findViewById(R.id.imgRvItemProfile)
    val txtRvItemId: TextView = view.findViewById(R.id.txtRvItemId)

    val context: Context = view.context

    fun bind(data: GitFollowerItem){
        txtRvItemId.text = data.id
        Glide.with(context).load(data.imgProfile).into(imgRvItemProfile)
        itemView.setOnClickListener {
            val intent = Intent(context, GitRepoListActivity::class.java)
            intent.putExtra("id", data.id)
            intent.putExtra("profileImageUrl", data.imgProfile)
            context.startActivity(intent)
        }

    }

}