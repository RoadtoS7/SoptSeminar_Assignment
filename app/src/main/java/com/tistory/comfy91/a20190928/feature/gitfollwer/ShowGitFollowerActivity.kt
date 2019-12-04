package com.tistory.comfy91.a20190928.feature.gitfollwer

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.tistory.comfy91.a20190928.R
import com.tistory.comfy91.a20190928.data.gitFollower.GetFollowerData
import com.tistory.comfy91.a20190928.data.gitFollower.ServerFollowerDataRepository
import com.tistory.comfy91.a20190928.feature.user_profile.UserProfileFragment
import kotlinx.android.synthetic.main.activity_show_git_follower.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShowGitFollowerActivity : AppCompatActivity() {
    private val TAG = javaClass.simpleName

    private lateinit var gitFollowerAdapter: GitFollowerAdapter // 뷰

    private lateinit var id:String // data

    val gitFollowerRepository = ServerFollowerDataRepository() // server

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_git_follower)

        // 엘비스 연산자 ?:
        // null operator ?. 와 달리 nullable type 변수가 null 인경우에 지정한 default 값 반환
        id = intent.getStringExtra("id") ?: ""

        // 프로필 생성
        makeProfile()

        // 팔로워 리스트 생성
        makeFollowerListView()

    } // end onCreate


    // 상단 프로필 만듬
    private fun makeProfile(){
        val profileFragment = UserProfileFragment.newInstance(id)

        val transaction = supportFragmentManager.beginTransaction()
        transaction
            .replace(R.id.layout_container, profileFragment)
            .commit()
    }

    private fun makeFollowerListView(){

        // 리사이클러뷰 및 어댑터 생성
        // 연결
        gitFollowerAdapter = GitFollowerAdapter(this)
        rvShowGitFolRepo.adapter = gitFollowerAdapter
        rvShowGitFolRepo.layoutManager = LinearLayoutManager(this)

        // 팔로워 리스트 정보  서버로부터 받아옴
        gitFollowerRepository.getFollowers(id).enqueue(object: Callback<List<GetFollowerData>>{
            override fun onFailure(call: Call<List<GetFollowerData>>, t: Throwable) {
                Log.d(TAG, "Fail to Get Follower List, message : ${t.message}")
            }

            override fun onResponse(
                call: Call<List<GetFollowerData>>,
                response: Response<List<GetFollowerData>>
            ) {
                if(response.isSuccessful){
                    val followerList = response.body()

                    gitFollowerAdapter.data = followerList!!
                    gitFollowerAdapter.notifyDataSetChanged()
                }
                else{
                    Log.d(TAG, "Success to Get Follower List but Response is Null")
                }
            }

        })



    }



} // end class


