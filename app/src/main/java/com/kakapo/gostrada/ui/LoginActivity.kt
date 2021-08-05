package com.kakapo.gostrada.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kakapo.gostrada.R
import com.kakapo.gostrada.databinding.ActivityLoginBinding
import com.kakapo.gostrada.viewModel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        loginViewModelObserver()



        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            viewModel.getUserDataFromAPI()
            startActivity(intent)
        }

    }

    private fun loginViewModelObserver() {
        viewModel.userDataResponse.observe(this) { userData ->
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