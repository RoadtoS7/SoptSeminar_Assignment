package com.tistory.comfy91.a20190928.feature.gitfollwer

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tistory.comfy91.a20190928.data.gitFollower.GitFollowerItem
import com.tistory.comfy91.a20190928.R
import com.tistory.comfy91.a20190928.data.gitFollower.GetFollowerData

class GitFollowerAdapter(private val context: Context): RecyclerView.Adapter<GitFollowerViewHolder>(){
    var data = listOf<GetFollowerData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitFollowerViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.rv_item_follwer, parent, false)
        return GitFollowerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: GitFollowerViewHolder, position: Int) {
        holder.bind(data[position])
    }

}