package com.software1t.selldesk.app

import android.os.Bundle
import android.view.LayoutInflater
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.software1t.selldesk.R
import com.software1t.selldesk.base.BaseActivity
import com.software1t.selldesk.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var navController: NavController

    override val bindLayout: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun prepareView(savedInstanceState: Bundle?) {
        setupBottomNavigationView()
    }

    private fun setupBottomNavigationView() {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment, R.id.favoritesFragment, R.id.newPostFragment, R.id.messagesFragment, R.id.profileFragment -> {
                    binding.bottomNavigationView.isVisible = true
                }

                else -> {
                    binding.bottomNavigationView.isVisible = false
                }
            }
        }

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home_screen -> {
                    navController.navigate(R.id.homeFragment)
                    true
                }

                R.id.favorites_screen -> {
                    navController.navigate(R.id.favoritesFragment)
                    true
                }

                R.id.new_post_screen -> {
                    navController.navigate(R.id.newPostFragment)
                    true
                }

                R.id.messages_screen -> {
                    navController.navigate(R.id.messagesFragment)
                    // Respond to navigation item 2 click
                    true
                }

                R.id.profile_screen -> {
                    navController.navigate(R.id.profileFragment)
                    // Respond to navigation item 2 click
                    true
                }

                else -> false
            }

        }

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}