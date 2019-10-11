package com.tistory.comfy91.a20190928

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    private var edtSignInId: EditText? = null
    private var edtSignInPw: EditText? = null
    private var btnSignInSignUp: TextView? = null
    private var btnSignInSignIn: TextView? = null
    private val REQUEST_SIGNUP = 1001


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 작업한 xml파일을 현재 액티비티의 레이아웃으로 지정한다.
        // 이함수로 인해서 현재 작업한 xml파일이 화면에 보이게 됨
        // 레이아웃 파일을 메모리로 로드한다.
        setContentView(R.layout.activity_sign_in)

        Log.d("With Sopt", "Sign In Activity is created")
        // -> D:With Sopt: Sign In Activity is created
        makeController()




    } // end onCraete()

    // 사용자 입력을 받아서 프로그램을 실행 하는 것(controller) 을 초기화 하는 것
    private fun makeController(){
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
            var response = requestLogin(id, pw)
            if(response){
                val intent = Intent(this, SignUpActivity::class.java)

                startActivity(intent)
            }
            else{
                // 로그인 실패했으면 Toast를 사용해 로그인이 실패했다고 알려주고 아이디 혹은 비밀번호를 다시 입력하게 포커스를 이동시켜주자.
                Toast.makeText(this, "로그인에 실패했습니다.",Toast.LENGTH_LONG).show()
                Log.d(localClassName,"Fail Login")
            }
        }

        // 익명클래스를 사용한 click이벤트 구현
        btnSignInSignUp?.setOnClickListener(
            object : View.OnClickListener{
                override fun onClick(p0: View?) { // 파라미터는 클린 view의 참조
                    // 회원 가입 페이지로 이동해야한다.
                    val intent = Intent(this@SignInActivity, SignUpActivity::class.java)
                    startActivityForResult(intent,REQUEST_SIGNUP)
                }

            }
        )



    } // end makeController

    private fun requestLogin(id:String , pw: String): Boolean{
        Log.d("SooHyeon", "request login id: $id pw: $pw")
        return true
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





    }
}
