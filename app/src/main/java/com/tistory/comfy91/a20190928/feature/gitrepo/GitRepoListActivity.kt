package com.tistory.comfy91.a20190928.feature.gitrepo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.tistory.comfy91.a20190928.R
import com.tistory.comfy91.a20190928.data.gitrepo.GetGitRepoData
import com.tistory.comfy91.a20190928.data.gitrepo.ServerGitRepoRepository
import com.tistory.comfy91.a20190928.feature.user_profile.UserProfileFragment
import com.tistory.comfy91.recyclerview.GitRepoAdapter
import kotlinx.android.synthetic.main.activity_gitrepo_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitRepoListActivity : AppCompatActivity() {
    private val TAG = javaClass.simpleName

    // 리사이클러뷰, 리사이클러뷰 어댑터, 스냅핼퍼
    private lateinit var gitRepoAdapter: GitRepoAdapter
    private lateinit var snapHelper: LinearSnapHelper

    // 서버 통신
    private val gitRepoRespository = ServerGitRepoRepository()


    // data
    private var id: String = ""
    private lateinit var name: String
    private lateinit var profileImageUrl: String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gitrepo_list)

        // id, profileImageUrl 꺼내욤
        id = intent.getStringExtra("id")?:""
        profileImageUrl = intent.getStringExtra("profileImageUrl")!!

        makeController()


    } // end onCreate()


    // 뷰 생성 및 데이터 설정
    private fun makeController(){
        makeProflie()
        makeRepositoryList()
    }

    // 프로필 생성
    private fun makeProflie(){
        val profileFragment = UserProfileFragment.newInstance(id)

        val transaction = supportFragmentManager.beginTransaction()
        transaction
            .replace(R.id.layout_container, profileFragment)
            .commit()

    }

    // 레포지터리 리스트 생성
    private fun makeRepositoryList(){
        gitRepoAdapter = GitRepoAdapter(this)
        snapHelper = LinearSnapHelper()

        rvMainGitRepo.adapter= gitRepoAdapter
        rvMainGitRepo.layoutManager = LinearLayoutManager(this)
        snapHelper.attachToRecyclerView(rvMainGitRepo)

        gitRepoRespository.getRepos(id).enqueue(object: Callback<List<GetGitRepoData>>{
            override fun onFailure(call: Call<List<GetGitRepoData>>, t: Throwable) {
                Log.d(TAG, "Fail to Request Get Repository, message: ${t.message}")
            }

            override fun onResponse(
                call: Call<List<GetGitRepoData>>,
                response: Response<List<GetGitRepoData>>
            ) {
                if(response.isSuccessful){
                    Log.d(TAG, "Success to Request Get Repository")
                    val body = response.body()

                    gitRepoAdapter.data =  body!! // 어댑터에 데이터 설정
                    gitRepoAdapter.notifyDataSetChanged()

                }
                else{
                    Log.d(TAG, "Success to Request Get Repository But response is Null")
                }

            }

        })

    } // end makeRepositoryList()

} // end class
