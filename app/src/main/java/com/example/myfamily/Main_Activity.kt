package com.example.myfamily

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class Main_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val Bottombar = findViewById<BottomNavigationView>(R.id.bottom_navbar)
        Bottombar.setOnItemSelectedListener {

            if (it.itemId == R.id.Nav_guard) {
                inflateFragment(GuardFragment.newInstance())
            } else if (it.itemId == R.id.Nav_home) {
                inflateFragment(HomeFragment.newInstance())
            } else if (it.itemId == R.id.Nav_dashboard) {
                inflateFragment((DashboardFragment.newInstance()))
            } else if(it.itemId == R.id.Nav_profile){
                inflateFragment(ProfileFragment.newInstance())
            }

            true
        }
        Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show()
    }

    private fun inflateFragment(newInstance: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, newInstance)
        transaction.commit()
    }
}