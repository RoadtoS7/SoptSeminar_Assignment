package com.tistory.comfy91.a20190928.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// 서비스 객체 싱글톤 패턴으로 구현
object GithubServiceImpl{
    // 서비스 요청할 서버 URL
    private const val BASE_URL = "https://api.github.com"

    // 서비스를 만들어주는 RetrofitBuilder 만듬
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL) // 베이스 유알엘 설정
        .addConverterFactory(GsonConverterFactory.create()) // 인터넷 통신으로 받아온 정보를 Gson Converter를 이용하여 객체로 만듬
        .build()

    // 서비스를 만듬
    val service: GithubService = retrofit.create(GithubService::class.java)
}