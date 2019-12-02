package com.tistory.comfy91.a20190928.data.gitrepo

import retrofit2.Call
import com.tistory.comfy91.a20190928.data.GetGitRepoData


interface GitRepoRepository{
    /**
     * login 한 유저의 GitRepo를 리스트 형태로 반환하는 함수
     */
    fun getRepos(login: String) : Call<List<GetGitRepoData>>
}