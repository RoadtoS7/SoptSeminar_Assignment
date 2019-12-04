package com.tistory.comfy91.a20190928.data.gitrepo

import com.tistory.comfy91.a20190928.api.GithubServiceImpl
import retrofit2.Call

class ServerGitRepoRepository : GitRepoRepository {
    override fun getRepos(login: String): Call<List<GetGitRepoData>> {
        return GithubServiceImpl.service.getRepos(login)
    }

}