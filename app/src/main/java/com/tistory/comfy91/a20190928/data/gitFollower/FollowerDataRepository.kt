package com.tistory.comfy91.a20190928.data.gitFollower

import retrofit2.Call

interface FollowerDataRepository {
    fun getFollowers(userName: String): Call<List<GetFollowerData>>
}