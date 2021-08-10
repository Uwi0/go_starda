package com.kakapo.gostrada.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kakapo.gostrada.R
import com.kakapo.gostrada.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        setupBottomNavigation()
    }

    private fun setupBottomNavigation(){
        val bottomNav: BottomNavigationView = binding!!.bottomNavigationMenu
        bottomNav.itemIconTintList = null
        val navController = findNavController(R.id.nav_host_fragment_main)
        bottomNav.setupWithNavController(navController)
    }
}