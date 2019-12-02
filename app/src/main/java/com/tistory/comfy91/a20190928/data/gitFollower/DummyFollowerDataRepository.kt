package com.tistory.comfy91.a20190928.data.gitFollower

import retrofit2.Call
import retrofit2.mock.Calls

class DummyFollowerDataRepository : FollowerDataRepository{
    override fun getFollowers(userName: String): Call<List<GetFollowerData>> {
        return Calls.response(
            listOf(
               GetFollowerData(
                    "Kim",
                    "https://www.google.com/url?sa=i&source=images&cd=&ved=2ahUKEwi2stKzjo3mAhVBFYgKHSSFC9IQjRx6BAgBEAQ&url=https%3A%2F%2Fwww.fandango.com%2Fmovie-photos%2Fseptember-celebrity-birthdays-335&psig=AOvVaw3zdqpZkSfOGEkQOQLtsiHv&ust=1575037591564467"
                ),
                GetFollowerData(
                    "Kadashiyan",
                    "https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwjRppm-jo3mAhWt3mEKHY0LD2kQjRx6BAgBEAQ&url=https%3A%2F%2Fwww.bbc.com%2Fnews%2Fhealth-47090374&psig=AOvVaw3zdqpZkSfOGEkQOQLtsiHv&ust=1575037591564467"

                ),
                GetFollowerData(
                    "Ari",
                    "https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwj4hoixj43mAhWdwosBHVajAAsQjRx6BAgBEAQ&url=https%3A%2F%2Fwww.popsugar.com%2Fbeauty%2FBest-Celebrity-Makeup-Artists-46290196&psig=AOvVaw3zdqpZkSfOGEkQOQLtsiHv&ust=1575037591564467"

                )
            )
        )
    }

}