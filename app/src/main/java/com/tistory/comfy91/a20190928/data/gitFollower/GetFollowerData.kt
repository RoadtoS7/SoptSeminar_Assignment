package com.tistory.comfy91.a20190928.data.gitFollower

import com.google.gson.annotations.SerializedName

data class GetFollowerData (
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val imgProfile: String

)