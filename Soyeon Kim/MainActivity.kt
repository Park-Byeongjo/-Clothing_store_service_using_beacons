package com.example.shoppinghelper

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // OnClickListener 설정
        button.setOnClickListener {
            // 입력한 이름 Toast 메시지로 출력
            Toast.makeText(this, editText.text, Toast.LENGTH_LONG).show()

            // 입력한 이름 화면에 출력
            textView2.text = "★" + editText.text + "님 반갑습니다★"

            // EditText 비움
            editText.setText("")

            // 키보드 숨김
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(editText.windowToken, 0)
        }
    }
}
