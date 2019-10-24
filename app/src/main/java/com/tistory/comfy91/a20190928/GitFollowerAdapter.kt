package com.tistory.comfy91.a20190928

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class GitFollowerAdapter(private val context: Context): RecyclerView.Adapter<GitFollowerViewHolder>(){
    var data = listOf<GitFollowerItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitFollowerViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.rv_item_follwer, parent, false)
        view.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
        return GitFollowerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: GitFollowerViewHolder, position: Int) {
        holder.bind(data[position])

    }

}