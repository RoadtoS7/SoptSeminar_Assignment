package com.tistory.comfy91.a20190928.feature.user_profile


import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

import com.tistory.comfy91.a20190928.R
import kotlinx.android.synthetic.main.fragment_user_profile.*


class UserProfileFragment : Fragment() {
    var userProfId :String? = null
    var userProfName :String? = null
    var userProfBio :String? = null
    var userProfImageUrl :String? = null


    lateinit var imgUserProf: ImageView
    private lateinit var txtUserProfId : TextView
    private lateinit var txtUserProfName: TextView
    private lateinit var txtUserProfBio: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view  = inflater.inflate(R.layout.fragment_user_profile, container, false)
        imgUserProf = view.findViewById(R.id.imgUserProf)


        txtUserProfId = view.findViewById(R.id.txtUserProfId)
        txtUserProfId.text = userProfId

        txtUserProfName = view.findViewById(R.id.txtUserProfName)
        txtUserProfName.text = userProfName

        txtUserProfBio = view.findViewById(R.id.txtUserProfBio)
        txtUserProfBio.text = userProfBio
        return view
    }

    // 프레그먼트는 액티비티에 종속적
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Glide.with(this@UserProfileFragment).load(userProfImageUrl).into(imgUserProf)

    }




}
