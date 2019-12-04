package com.tistory.comfy91.a20190928.feature.grid_recycelrview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tistory.comfy91.a20190928.data.supplement.GridItem
import com.tistory.comfy91.a20190928.R

class GridAdapter(private val context: Context) :RecyclerView.Adapter<GridViewHolder>(){
    var data = listOf<GridItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rv_item_grid, parent, false)
        return GridViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        holder.bind(data[position], context)
    }

}