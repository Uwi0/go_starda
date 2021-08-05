package com.kakapo.gostrada.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kakapo.gostrada.R
import com.kakapo.gostrada.databinding.ActivityLoginBinding
import com.kakapo.gostrada.model.entities.GoStrada
import com.kakapo.gostrada.viewModel.LoginViewModel
import kotlin.math.log

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        loginViewModelObserver()

        val username = binding.edUsername.text.toString()
        val password = binding.edPassword.text.toString()

        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            viewModel.postUserDataToAPi(username, password)
            startActivity(intent)
        }

    }

    private fun loginViewModelObserver() {
        viewModel.updateUserDataResponse.observe(this) { userData ->
            Log.i("Data User response", "$userData")
        }

        viewModel.userDataLoadingError.observe(this) { dataError ->
            dataError?.let {
                Log.e("get data error", "$dataError")
            }
        }

        viewModel.loadUserData.observe(this) { loadUserData ->
            Log.i("Data User Loading", "$loadUserData")
        }
    }
}