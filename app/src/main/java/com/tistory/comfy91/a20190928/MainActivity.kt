package com.tistory.comfy91.a20190928

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.tistory.comfy91.recyclerview.GitRepoAdapter
import com.tistory.comfy91.recyclerview.GitRepoItem

class MainActivity : AppCompatActivity() {

    lateinit var rvMainGitRepo: RecyclerView
    lateinit var gitRepoAdapter: GitRepoAdapter
    lateinit var snapHelper: LinearSnapHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // RecyclerView 생성
        rvMainGitRepo = findViewById(R.id.rvMainGitRepo)

        // RecyclerAdapter생성
        gitRepoAdapter = GitRepoAdapter(this)

        // SnapHelper 생성
        snapHelper = LinearSnapHelper()

        // RecyclerView에 RecyclerView 어댑터 설정
        rvMainGitRepo.adapter = gitRepoAdapter
        snapHelper.attachToRecyclerView(rvMainGitRepo)
        // viewHolder 들이 어떻게 배치될 지 설정
        rvMainGitRepo.layoutManager = LinearLayoutManager(this)

        // 어댑터에 데이터를 넣는다
        gitRepoAdapter.data = listOf(
            GitRepoItem(
                name = "SoptStagram",
                desc = "IT 창업 동아리 SOPT 안드로이드 교육 프로젝트",
                language = "Kotlin",
                languageColor = 0
            ),
            GitRepoItem(
                name = "artic_android",
                desc = "Forked from artic_development/artic_android",
                language = "Kotlin",
                languageColor = 0
            ),
            GitRepoItem(
                name = "CalculatorWithEspresso",
                desc = "UI Test with Espresso + Unit Test Calculator",
                language = "Kotlin",
                languageColor = 0
            ),
            GitRepoItem(
                name = "problemSovingGuZongMan",
                desc = "프로그래밍 대회에서 배우는 알고리즘 문제해결전략 공부하자",
                language = "Java",
                languageColor = 1
            )
        )


        // 데이터가 설정되었으니 반영해달라고 어댑터에 요청
        gitRepoAdapter.notifyDataSetChanged()




    }
}
