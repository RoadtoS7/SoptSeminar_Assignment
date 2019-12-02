package com.tistory.comfy91.a20190928.data.gitUser


import retrofit2.Call
import com.tistory.comfy91.a20190928.data.GetUserData

interface GitUserDataRepository {
    fun getUser(id: String): Call<GetUserData>
}