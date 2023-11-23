package com.software1t.selldesk.app

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.navigation.NavigationBarView
import com.software1t.selldesk.R
import com.software1t.selldesk.base.BaseActivity
import com.software1t.selldesk.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var navController: NavController

    override val bindLayout: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun prepareView(savedInstanceState: Bundle?) {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController


//        Bottom navigation
        val navView = NavigationBarView.OnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home_page -> {
                    Toast.makeText(this, "home_page", Toast.LENGTH_SHORT).show()
                    navController.navigate(R.id.homeFragment)
                    true
                }

                R.id.favorites_page -> {
                    Toast.makeText(this, "favorites_page", Toast.LENGTH_SHORT).show()
                    navController.navigate(R.id.detailsFragment)
                    true
                }

                R.id.add_new_page -> {
                    Toast.makeText(this, "add_new_page", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.messages_page -> {
                    // Respond to navigation item 2 click
                    true
                }

                R.id.menu_page -> {
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