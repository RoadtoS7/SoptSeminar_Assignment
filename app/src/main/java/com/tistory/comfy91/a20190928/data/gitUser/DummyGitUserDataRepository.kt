package com.tistory.comfy91.a20190928.data.gitUser

import com.tistory.comfy91.a20190928.data.GetUserData
import retrofit2.Call
import retrofit2.mock.Calls

class DummyGitUserDataRepository : GitUserDataRepository{
    override fun getUser(id: String): Call<GetUserData> {
        return Calls.response(
            GetUserData("Default Id","Default Name", "Default Bio", "https://www.google.com/url?sa=i&source=images&cd=&ved=2ahUKEwjXs5_Vg5fmAhWm-GEKHbqXAjcQjRx6BAgBEAQ&url=https%3A%2F%2Fwww.vogue.com%2Farticle%2Fariana-grande-social-house-boyfriend-music-video&psig=AOvVaw0dS7B-KoPBL_vyr1wnyttB&ust=1575378291505479")
        )
    }

}