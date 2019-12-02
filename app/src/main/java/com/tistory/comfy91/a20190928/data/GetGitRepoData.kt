package com.tistory.comfy91.a20190928.data

import com.google.gson.annotations.SerializedName
import org.intellij.lang.annotations.Language


data class GetGitRepoData (
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val descripntion: String?,
    @SerializedName("updated_at")
    val updatedAt: String?,
    @SerializedName("language")
    val language: String?
)