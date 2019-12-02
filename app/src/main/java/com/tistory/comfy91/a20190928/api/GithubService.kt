package com.tistory.comfy91.a20190928.api

import com.tistory.comfy91.a20190928.data.gitFollower.GetFollowerData
import com.tistory.comfy91.a20190928.data.GetGitRepoData
import com.tistory.comfy91.a20190928.data.GetUserData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Call

interface GithubService {
    @GET("/users/{login}")
    fun getUser(
        @Path("login") login: String
    ): Call<GetUserData>

    @GET("/users/{username}/followers")
    fun getFollowers(
        @Path("username") login: String
    ): Call<List<GetFollowerData>>

    @GET("/users/{login}/repos")
    fun getRepos(
        @Path("login") login : String
    ): Call<List<GetGitRepoData>>


}