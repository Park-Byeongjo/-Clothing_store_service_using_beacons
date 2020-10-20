package com.example.bss.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.bss.R
import com.example.bss.data.Auth
import com.example.bss.data.NODE_AUTH

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment(){
    private lateinit var viewModel: AuthViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val context = activity as AppCompatActivity
        btn_register.setOnClickListener {
            performRegister()
            activity?.let{
                val intent = Intent(context, AuthActivity::class.java)
                startActivity(intent)
            }
        }

    }


    private fun performRegister(){
        val id = edit_text_id.text.toString()
        val name = edit_text_name.text.toString()
        val password = edit_text_pass.text.toString()

        if(id.isEmpty() || password.isEmpty()){
            Toast.makeText(requireContext(), "Please enter text in ID or PW", Toast.LENGTH_SHORT).show()
            return
        }
        val auth = Auth(null, id, name, password)
        viewModel.addAuth(auth)
        if(viewModel.result.value == "Register Success"){
            Toast.makeText(requireContext(), "Register Success", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(requireContext(), "Register No Success", Toast.LENGTH_SHORT).show()
        }
    }

}