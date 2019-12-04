package com.tistory.comfy91.a20190928.feature.sign_in

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import retrofit2.Call



import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tistory.comfy91.a20190928.R
import com.tistory.comfy91.a20190928.api.GithubServiceImpl

import com.tistory.comfy91.a20190928.data.gitUser.GetUserData
import com.tistory.comfy91.a20190928.feature.sign_up.SignUpActivity
import com.tistory.comfy91.a20190928.feature.gitfollwer.ShowGitFollowerActivity
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {
    private var edtSignInId: EditText? = null
    private var edtSignInPw: EditText? = null
    private var btnSignInSignUp: TextView? = null
    private var btnSignInSignIn: TextView? = null
    private val REQUEST_SIGNUP = 1001
    private val TAG = SignInActivity::class.java.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 작업한 xml파일을 현재 액티비티의 레이아웃으로 지정한다.
        // 이함수로 인해서 현재 작업한 xml파일이 화면에 보이게 됨
        // 레이아웃 파일을 메모리로 로드한다.
        setContentView(R.layout.activity_sign_in)

//        val id = Login.getUser(this)
//        if(id.isNotEmpty()){
//            gotoFollowerListActivity(id)
//            finish()
//        }

        // 로그캣 모니터에서 확인 가능한 로그
        Log.d("With Sopt", "Sign In Activity is created")

        makeController()

    } // end onCraete()

    // 사용자 입력을 받아서 프로그램을 실행 하는 것(controller) 을 초기화 하는 것
    private fun makeController(){
        // layout 파일의 뷰 참조
        edtSignInId = findViewById(R.id.edtSignInId)
        edtSignInPw = findViewById(R.id.edtSignInPw)
        btnSignInSignUp = findViewById(R.id.btnSignInSignUp)
        btnSignInSignIn = findViewById(R.id.btnSignInSignIn)

        // kotlin 람다식을 이용한 click이벤트 구현
        btnSignInSignIn?.setOnClickListener{
        // ID, PW 둘중 하나라도 공백이면 눌리지 않는다.
            val id = edtSignInId?.text.toString()
            val pw = edtSignInPw?.text.toString()

            if(id.isEmpty() || pw.isEmpty()){
                Toast.makeText(this,  "아이디나 비밀번호를 입력해주세요.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            // 입력한 ID, 입력한 PW를 가지고 로그인 요청을 한다.
            // ShowGitFollowerActivity 로 이동
            val response = requestLogin(id, pw)
            if(response){
                // 로그인에 성공했으면 SharedPreferences에 아이디 저장
                Login.setUser(this, id)
                gotoFollowerListActivity(id)
            }
            else{
                Toast.makeText(this, "로그인에 실패했습니다.", Toast.LENGTH_LONG).show()
                edtSignInId?.requestFocus()
            }

        }

        // 익명클래스를 사용한 click이벤트 구현
        btnSignInSignUp?.setOnClickListener(
            object : View.OnClickListener{
                override fun onClick(p0: View?) { // 파라미터는 클릭된 뷰를 참조한다.
                    // 회원 가입 페이지로 이동해야한다.
                    val intent = Intent(this@SignInActivity, SignUpActivity::class.java)
                    startActivityForResult(intent,REQUEST_SIGNUP)
                }

            }
        )



    } // end makeController


    // 서버에 로그인 요청
    private fun requestLogin(id:String , pw: String): Boolean{
        return true
//        Log.d("SooHyeon", "request login id: $id pw: $pw")
//
//        val call: Call<GetUserData> = GithubServiceImpl.service.getUser(id)
//        call.enqueue(object: Callback<GetUserData>{
//            override fun onFailure(call: Call<GetUserData>, t: Throwable) {
//                Log.d(TAG, "Request Login Failed " + t.message)
//            }
//
//            override fun onResponse(call: Call<GetUserData>, response: Response<GetUserData>) {
//                if(response.isSuccessful){
//                    Log.d(TAG, " Request Login Successful ")
//                    val responseData = response.body()
//                    Log.d(TAG, "(id : ${responseData?.login}) (name : ${responseData?.name}) (bio : ${responseData?.bio})")
//
//                    goToShowGitFollowerActivity(id, responseData!!.bio, responseData!!.name, responseData!!.profileImageUrl)
//
//
//                } else{
//                    Log.d(TAG,"Request Login Failed : onResponse is not Successful")
//
//                    // 로그인 실패했으면 Toast를 사용해 로그인이 실패했다고 알려주고 아이디 혹은 비밀번호를 다시 입력하게 포커스를 이동시켜주자.
//                    Toast.makeText(this@SignInActivity, "로그인에 실패했습니다.",Toast.LENGTH_LONG).show()
//                    Log.d(TAG,"Fail Login")
//                }
//            }
//
//        })


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_SIGNUP){
            if(resultCode == Activity.RESULT_OK){
                Log.d(localClassName, "Activity Result : Success SignUp")
                val id = data?.getStringExtra("id")
                val pw = data?.getStringExtra("pw")
                Log.d(localClassName, "Get Data From Intent: id: $id pw: $pw")

                edtSignInId?.setText(id)
                edtSignInPw?.setText(pw)
            }
        }

    } // end onActivityResult()


    private fun gotoFollowerListActivity(id: String){
        val intent = Intent(this, ShowGitFollowerActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }
}
