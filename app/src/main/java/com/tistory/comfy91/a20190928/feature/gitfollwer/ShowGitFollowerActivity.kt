package com.tistory.comfy91.a20190928.feature.gitfollwer

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tistory.comfy91.a20190928.R
import com.tistory.comfy91.a20190928.data.GitFollowerItem
import com.tistory.comfy91.a20190928.data.gitFollower.GetFollowerData
import com.tistory.comfy91.a20190928.data.gitFollower.ServerFollowerDataRepository
import com.tistory.comfy91.a20190928.feature.user_profile.UserProfileFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShowGitFollowerActivity : AppCompatActivity() {
    val TAG = javaClass.simpleName

    // 뷰
    lateinit var rvShowGitFol: RecyclerView
    lateinit var gitFollowerAdapter: GitFollowerAdapter


    // data
    lateinit var id:String
    var name: String? = null
    var bio: String? = null
    private lateinit var profileImageUrl: String


    // server
    val gitRepository = ServerFollowerDataRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_git_follower)

        id = intent.getStringExtra("id")!!
        name= intent.getStringExtra("name")
        bio = intent.getStringExtra("bio")


        profileImageUrl = intent.getStringExtra("profileImageUrl")!!
        Log.d(TAG, "(id : $id) (name: $name) (bio: $bio)")
        // 리사이클러뷰 및 어댑터 생성
        // 연결
        rvShowGitFol = findViewById(R.id.rvShowGitFolRepo)
        gitFollowerAdapter =
            GitFollowerAdapter(this)
        rvShowGitFol.adapter = gitFollowerAdapter

        // 어댑터에 배치 레이아웃 설정
        rvShowGitFol.layoutManager = LinearLayoutManager(this);

        // 팔로워 데이터를 서버로부터 얻어오기 및
        getFollowerFromServer(id)

        // fragment 선언
        val userProfFragment = UserProfileFragment()
        userProfFragment.userProfId=  id
        userProfFragment.userProfName = name
        userProfFragment.userProfBio = bio
        userProfFragment.userProfImageUrl = profileImageUrl

//        userProfFragment.imgUserProfListener = View.OnClickListener {
//            val intent = Intent(this@ShowGitFollowerActivity, GitRepoListActivity::class.java)
//            intent.putExtra("Id", id)
//            intent.putExtra("name", name)
//            intent.putExtra("bio", bio)
//            startActivity(intent)
//        }


        // fragment 추가
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.layout_container, userProfFragment)
        transaction.commit()

    } // end onCreate

    fun convertTogitFollwerList(data: List<GetFollowerData>?): List<GitFollowerItem>{
        var gitFollowerList = ArrayList<GitFollowerItem>()
        if (data != null) {
            for( x in data){
                gitFollowerList.add(GitFollowerItem(x.imgProfile, x.login))
            }
        }
        return gitFollowerList

    }

    private fun getFollowerFromServer(id: String){
        gitRepository.getFollowers(id).enqueue(object: Callback<List<GetFollowerData>> {
            override fun onFailure(call: Call<List<GetFollowerData>>, t: Throwable) {
                Log.d(TAG, "Fail to Get Follower Data, message: ${t.message}")
            }

            override fun onResponse(
                call: Call<List<GetFollowerData>>,
                response: Response<List<GetFollowerData>>
            ) {
              if(response.isSuccessful){
                Log.d(TAG, "Sucess to Get Follower data")
                gitFollowerAdapter.data = convertTogitFollwerList(response.body())
                gitFollowerAdapter.notifyDataSetChanged()

              }
                else{
                  Log.d(TAG, "Sucess to Get Follower data but Response is Null")

              }
            }
        })
    }




} // end class


