package com.example.bss.ui.setting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.bss.R
import com.example.bss.ui.login.AuthActivity
import com.example.bss.ui.search.SearchViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_setting.*

class SettingFragment : Fragment() {

    private lateinit var settingViewModel: SettingViewModel
    private val fAuth = FirebaseAuth.getInstance()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val auth = fAuth.currentUser
        if(auth != null){
            textView8.setText(fAuth.currentUser?.email)

        }

        logout.setOnClickListener {
            Firebase.auth.signOut()
            Toast.makeText(requireContext(),"Logout!", Toast.LENGTH_SHORT).show()
            activity?.let{
                val intent = Intent(context, AuthActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
