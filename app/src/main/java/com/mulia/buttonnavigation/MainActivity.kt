package com.mulia.buttonnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mulia.buttonnavigation.fragment.HomeFragment
import com.mulia.buttonnavigation.fragment.NotificationFragment
import com.mulia.buttonnavigation.fragment.SettingsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val notificationFragment = NotificationFragment()
        val settingsFragment = SettingsFragment()

        makeCurrentFragment(homeFragment)

        val buttom_navigation = findViewById<BottomNavigationView>(R.id.button_navigation)

        buttom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_home ->makeCurrentFragment(homeFragment)
                R.id.menu_notification ->makeCurrentFragment(notificationFragment)
                R.id.menu_setting ->makeCurrentFragment(settingsFragment)

            }
            true
        }

    }


    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fram_nav, fragment)
            commit()

        }

    }
}