package com.tistory.comfy91.a20190928.feature.gitfollwer

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tistory.comfy91.a20190928.R
import com.tistory.comfy91.a20190928.data.gitFollower.GetFollowerData
import com.tistory.comfy91.a20190928.data.gitFollower.GitFollowerItem
import com.tistory.comfy91.a20190928.feature.gitrepo.GitRepoListActivity

// 뷰 폴더는 각 아이템에 해당하는 뷰 객체를 가지고 있다.
class GitFollowerViewHolder(view: View): RecyclerView.ViewHolder(view){

    val imgRvItemProfile: ImageView = view.findViewById(R.id.imgRvItemProfile)
    val txtRvItemId: TextView = view.findViewById(R.id.txtRvItemId)

    val context: Context = view.context

    fun bind(data: GetFollowerData){
        txtRvItemId.text = data.login
        Glide.with(context).load(data.imgProfile).into(imgRvItemProfile)


        // itemView 를 사용하면 하나의 아이템 뷰를 의미한다.
        itemView.setOnClickListener {
            val intent = Intent(context, GitRepoListActivity::class.java)
            intent.putExtra("id", data.login)
            intent.putExtra("profileImageUrl", data.imgProfile)
            context.startActivity(intent)
        }

    }

}