package com.tistory.comfy91.a20190928.feature.gitrepo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.tistory.comfy91.a20190928.R
import com.tistory.comfy91.a20190928.api.GithubServiceImpl
import com.tistory.comfy91.a20190928.data.GetGitRepoData
import com.tistory.comfy91.a20190928.data.GetUserData
import com.tistory.comfy91.a20190928.data.gitUser.ServerGitUserDataRepository
import com.tistory.comfy91.a20190928.data.gitrepo.ServerGitRepoRepository
import com.tistory.comfy91.a20190928.feature.user_profile.UserProfileFragment
import com.tistory.comfy91.recyclerview.GitRepoAdapter
import com.tistory.comfy91.recyclerview.GitRepoItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitRepoListActivity : AppCompatActivity() {
    val TAG = javaClass.simpleName

    lateinit var id: String
    lateinit var name: String
    lateinit var profileImageUrl: String
    lateinit var bio: String

    lateinit var rvMainGitRepo: RecyclerView
    lateinit var gitRepoAdapter: GitRepoAdapter
    lateinit var snapHelper: LinearSnapHelper


    val gitRepoRespository = ServerGitRepoRepository()
    val gitUserDataRepository = ServerGitUserDataRepository()

    // Fragment 생성
    val userProfFragment = UserProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // id, profileImageUrl 꺼내욤
        id = intent.getStringExtra("id")!!
        profileImageUrl = intent.getStringExtra("profileImageUrl")!!

        // bio, name 얻어오기
        getUserProfInfo(id)

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


        // 어댑터에 데이터 가져옴
        getRepositoriesFromServer(id)






    } // end onCreate()

    fun setFragmentData(){
        userProfFragment.userProfId=  id
        userProfFragment.userProfName = name
        userProfFragment.userProfImageUrl = profileImageUrl
        userProfFragment.userProfBio = bio

        // fragment 추가
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.layout_container, userProfFragment)
        transaction.commit()
    }


    fun getRepositoriesFromServer(id: String){
        val call: Call<List<GetGitRepoData>> = gitRepoRespository.getRepos(id)
        call.enqueue(object: Callback<List<GetGitRepoData>>{
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
                    gitRepoAdapter.data =  convertToRecyclerViewData(body!!) // 어댑터에 데이터 설정
                    gitRepoAdapter.notifyDataSetChanged()

                }
                else{
                    Log.d(TAG, "Success to Request Get Repository But response is Null")
                }

            }

        })
    } // end of getRepositoriesFromServer()

    fun convertToRecyclerViewData(body: List<GetGitRepoData>): List<GitRepoItem>{
        var result = arrayListOf<GitRepoItem>()

        for(i in body){
            result.add(
                GitRepoItem(i.name, i.descripntion, i.language)
            )
        }
        return result
    }// end of convertToRecyclerViewData()



    fun getImageProfileUrl(id: String){
        val call: Call<GetUserData> = GithubServiceImpl.service.getUser(id)
        call.enqueue(object: Callback<GetUserData> {
            override fun onFailure(call: Call<GetUserData>, t: Throwable) {
                Log.d(TAG, "Fail Request Profile Image : ${t.message}")
            }

            override fun onResponse(call: Call<GetUserData>, response: Response<GetUserData>) {

                if(response.isSuccessful){
                    Log.d(TAG, "Success Request Profile Image ")
//                    val userData: GetUserData? = response.body()
//                    userData?.

                }
                else{

                }
            }

        })
    } // end of getImageProfileUrl()


    // 프로필을 위한 바이오, 이름 얻어오기
    private fun getUserProfInfo(id: String){
        gitUserDataRepository.getUser(id).enqueue(object: Callback<GetUserData>{
            override fun onFailure(call: Call<GetUserData>, t: Throwable) {
                Log.d(TAG,"Fail to Request User Prof Data, message: ${t.message}")
            }

            override fun onResponse(call: Call<GetUserData>, response: Response<GetUserData>) {
                if(response.isSuccessful){
                    Log.d(TAG,"Success to Request User Prof Data")
                    val userProfData = response.body()
                    name = userProfData!!.name
                    bio = userProfData.bio
                    setFragmentData()
                }
                else{
                    Log.d(TAG,"Success to Get User Prof Data but Response is null")
                }

            }

        })

    }

} // end class
