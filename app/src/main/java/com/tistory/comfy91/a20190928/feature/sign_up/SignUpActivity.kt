package com.tistory.comfy91.a20190928.feature.sign_up


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tistory.comfy91.a20190928.R

class SignUpActivity : AppCompatActivity() {
    private var edtSignUpName: EditText? = null
    private var edtSignUpId: EditText? = null
    private var edtSignUpPw: EditText? = null
    private var edtSignUpPwCheck: EditText? = null
    private var btnSignUpSignUp: Button? = null
    private var edtSignUpPhone: EditText? = null
    private val TAG = SignUpActivity::class.java.simpleName



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        makeController()
    }

    private fun makeController(){
        edtSignUpName = findViewById(R.id.edtSignUpName)
        edtSignUpId = findViewById(R.id.edtSignUpId)
        edtSignUpPw = findViewById(R.id.edtSignUpPw)
        edtSignUpPwCheck = findViewById(R.id.edtSignUpPwCheck)
        btnSignUpSignUp = findViewById(R.id.btnSignUpSignUp)
        edtSignUpPhone = findViewById(R.id.edtSignUpPhone)

        btnSignUpSignUp?.setOnClickListener {
            val name = edtSignUpName?.text.toString()
            val id = edtSignUpId?.text.toString()
            val pw = edtSignUpPw?.text.toString()
            val pwCheck = edtSignUpPwCheck?.text.toString()
            val phoneNum = edtSignUpPhone?.text.toString()

            if(name.isEmpty() || id.isEmpty()
                || pw.isEmpty() || pwCheck.isEmpty()){
                Toast.makeText(this, "입력칸을 전부 채워주세요.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if(pw.equals(pwCheck)){


//                var intent = Intent()
//                Log.d(localClassName, "name: $name id: $id pw: $pw pwCheck: $pwCheck")
//                intent.putExtra("id", id)
//                intent.putExtra("pw", pw)
//                setResult(Activity.RESULT_OK, intent)
//                finish()

            }


        }




    }
} // end class
