package com.tistory.comfy91.recyclerview

data class GitRepoItem(
    val name: String,
    val desc: String?,
    val language: String? // 없을 수도 있어서 null가능한 타입으로 선언한다.


)