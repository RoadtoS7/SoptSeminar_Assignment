package com.tistory.comfy91.a20190928.data.gitUser

import com.tistory.comfy91.a20190928.api.GithubServiceImpl
import retrofit2.Call

class ServerGitUserDataRepository :GitUserDataRepository{
    override fun getUser(id: String): Call<GetUserData> {
        return GithubServiceImpl.service.getUser(id)
    }

}