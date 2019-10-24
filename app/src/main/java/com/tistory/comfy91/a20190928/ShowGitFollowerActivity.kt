package com.tistory.comfy91.a20190928

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ShowGitFollowerActivity : AppCompatActivity() {
    lateinit var rvShowGitFol: RecyclerView
    lateinit var gitFollowerAdapter: GitFollowerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_git_follower)

        // 리사이클러뷰 및 어댑터 생성
        // 연결
        rvShowGitFol = findViewById(R.id.rvShowGitFolRepo)
        gitFollowerAdapter = GitFollowerAdapter(this)
        rvShowGitFol.adapter = gitFollowerAdapter

        // 어댑터에 배치 레이아웃 설정
        rvShowGitFol.layoutManager = LinearLayoutManager(this);

        // 어댑터에 데이터 설정
        gitFollowerAdapter.data = listOf(
            GitFollowerItem(
                id = "abc",
                name = "가나다"
            ),
            GitFollowerItem(
                id = "def",
                name = "라마바"
            ),
            GitFollowerItem(
                id = "ghi",
                name = "사아자"
            )
        )

        // 데이터 반영
        gitFollowerAdapter.notifyDataSetChanged()


    } // end onCreate
} // end class
