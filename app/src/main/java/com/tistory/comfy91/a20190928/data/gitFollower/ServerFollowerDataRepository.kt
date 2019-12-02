package com.tistory.comfy91.a20190928.data.gitFollower

import com.tistory.comfy91.a20190928.api.GithubServiceImpl
import retrofit2.Call

class ServerFollowerDataRepository: FollowerDataRepository{
    override fun getFollowers(id: String): Call<List<GetFollowerData>> {
        return GithubServiceImpl.service.getFollowers(id)
    }

}