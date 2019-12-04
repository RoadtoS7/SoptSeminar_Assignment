package com.tistory.comfy91.recyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tistory.comfy91.a20190928.R
import com.tistory.comfy91.a20190928.data.gitrepo.GetGitRepoData
import com.tistory.comfy91.a20190928.feature.gitfollwer.ShowGitFollowerActivity

// 1. 어댑터는 화면을 그려주기 위해서 conext를 멤버변수로 가진다.
// 2. 어댑터는 RecyclerView.Adapter를 상속받는다. <VewHolder> 해당 어댑터가 데이터를 어떤 뷰홀더로 변경하는지 알려준다.
class GitRepoAdapter(private val context: Context): RecyclerView.Adapter<GitRepoViewHolder>(){

    // 3. Adapter는 ViewHolder로 변경할 data를 가지고 있는다.
    var data = listOf<GetGitRepoData>()

    // 4. Adapter는 아이템마바 ViewHolder를 만드는 방법을 정의해야한다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitRepoViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rv_item_repository, parent, false )
        return GitRepoViewHolder(view)
    }

    // 5. Adpater는 전체 아이템의 숫자를 알아야한다.
    override fun getItemCount(): Int {
        return data.size
    }

    // 6. Adapter는 ViewHolder에 data를 전달해주어야한다.
    override fun onBindViewHolder(holder: GitRepoViewHolder, position: Int) {
        holder.bind(data[position])

    }

}