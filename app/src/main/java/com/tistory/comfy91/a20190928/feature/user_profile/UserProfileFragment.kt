package com.tistory.comfy91.a20190928.feature.user_profile


import android.os.Bundle
import android.text.LoginFilter
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.tistory.comfy91.a20190928.R
import com.tistory.comfy91.a20190928.data.gitUser.DummyGitUserDataRepository
import com.tistory.comfy91.a20190928.data.gitUser.GetUserData
import com.tistory.comfy91.a20190928.data.gitUser.ServerGitUserDataRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val ARG_LOGIN = "login"

class UserProfileFragment() : Fragment() {

    private var login: String? = null
    private val TAG = javaClass.simpleName

    lateinit var imgUserProf: ImageView
    private lateinit var txtUserProfId : TextView
    private lateinit var txtUserProfName: TextView
    private lateinit var txtUserProfBio: TextView

    private var userRepository =  ServerGitUserDataRepository()


    // - onCreate = Fragment가 생성될 때 호출되는 부분(메모리에)
    //- onCreateView = onCreate 후에 화면을 구성할 때 호출되는 부분
    //따라서 onCrateView부분이 activity에서 oncreate부분과 같이 layout파일에서 뷰를 참조하는 부분이다.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        arguments?.let{
            login = it.getString(ARG_LOGIN)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view  = inflater.inflate(R.layout.fragment_user_profile, container, false)
        return view
    }

    // 프레그먼트는 액티비티에 종속적 -> 액티비티의 onCreate() 가 호출된 후 호출된다.
    // 프레그먼트에서 액티비티에 접근하여 작업하려면 이 함수에서 해야함
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        view?.let{
            txtUserProfId = it.findViewById(R.id.txtUserProfId)
            txtUserProfName = it.findViewById(R.id.txtUserProfName)
            txtUserProfBio = it.findViewById(R.id.txtUserProfBio)
            imgUserProf = it.findViewById(R.id.imgUserProf)

            login?.let{ login ->
                userRepository.getUser(login).enqueue(object: Callback<GetUserData> {
                    override fun onFailure(call: Call<GetUserData>, t: Throwable) {
                        Log.d(TAG, "Fail to Get Profile Fragment Id, message : ${t.message}")
                    }

                    override fun onResponse(
                        call: Call<GetUserData>,
                        response: Response<GetUserData>
                    ) {
                        if(response.isSuccessful){
                            val chosenUser = response.body()!!
                            Log.d(TAG, "Succes Get Profile Fragment Id, $chosenUser")

                            // 프레그먼트 구성 뷰에 데이터 넣음
                            txtUserProfId.text = chosenUser.login
                            txtUserProfName.text = chosenUser.name
                            txtUserProfBio.text = chosenUser.bio

                            Glide
                                .with(this@UserProfileFragment)
                                .load(chosenUser.profileImageUrl)
                                .into(imgUserProf)


                        }
                        else{
                            Toast.makeText(context, "프로필 데이터 로딩 실패", Toast.LENGTH_LONG).show()

                        }
                    }
                }) // end enqueue

            } // end login let

        } // end view let



    } // end onActivityCreated()



    companion object{
        fun newInstance(id: String) = UserProfileFragment().apply{
            arguments = Bundle().apply{
                putString(ARG_LOGIN, id)
            }
        }
    }

} // end class
