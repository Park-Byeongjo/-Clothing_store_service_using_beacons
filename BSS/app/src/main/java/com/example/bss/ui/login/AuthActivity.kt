package com.example.bss.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.bss.MainActivity
import com.example.bss.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AuthActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
    }
    // onStart. 유저가 앱에 이미 구글 로그인을 했는지 확인
    public override fun onStart() {
        super.onStart()
        val currentUser = Firebase.auth.currentUser
        if(currentUser!=null){ // 이미 로그인 되어있을시 바로 메인 액티비티로 이동
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    } //onStart End

}



fun AppCompatActivity.replaceFragment(fragment: Fragment){
    val fragmentManager = supportFragmentManager
    val transaction = fragmentManager.beginTransaction()
    transaction.replace(R.id.activityAuth, fragment)
    transaction.addToBackStack(null)
    transaction.commit()
}