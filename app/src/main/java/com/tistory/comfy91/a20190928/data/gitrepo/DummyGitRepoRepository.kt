package com.tistory.comfy91.a20190928.data.gitrepo

import com.tistory.comfy91.a20190928.data.GetGitRepoData
import retrofit2.Call
import retrofit2.mock.Calls

class DummyGitRepoRepository: GitRepoRepository {
    override fun getRepos(login: String): Call<List<GetGitRepoData>> {
        return Calls.response(
            listOf(
                GetGitRepoData(
                    name = "SoptStagram",
                    descripntion = "IT 창업 동아리 SOPT 안드로이드 교육 프로젝트",
                    language = "Kotlin",
                    updatedAt =  "2011-01-26T19:14:43Z"

                ),
                GetGitRepoData(
                    name = "artic_android",
                    descripntion = "Forked from artic_development/artic_android",
                    language = "Kotlin",
                    updatedAt = "2011-01-26T19:14:43Z"
                ),
                GetGitRepoData(
                    name = "CalculatorWithEspresso",
                    descripntion = "UI Test with Espresso + Unit Test Calculator",
                    language = "Kotlin",
                    updatedAt = "2011-01-26T19:14:43Z"
                ),
                GetGitRepoData(
                    name = "problemSovingGuZongMan",
                    descripntion = "프로그래밍 대회에서 배우는 알고리즘 문제해결전략 공부하자",
                    language = "Java",
                    updatedAt = "2011-01-26T19:14:43Z"
                )
            )
        )
    }

}