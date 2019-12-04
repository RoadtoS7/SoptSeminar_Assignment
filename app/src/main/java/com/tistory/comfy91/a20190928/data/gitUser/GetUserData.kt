package com.tistory.comfy91.a20190928.data.gitUser

import com.google.gson.annotations.SerializedName

// 아이디
// 이름
// 사용자 설명
data class GetUserData (
    @SerializedName("login")
    val login: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("bio")
    val bio: String,
    @SerializedName("avatar_url")
    val profileImageUrl: String
)

