package com.example.cleaningapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //hide title bar
        getSupportActionBar()?.hide()

        //instance
        val bottomNav:BottomNavigationView = findViewById(R.id.bottomNavigationView);

        //set fragment
        val accountFragment=AccountFragment()
        val berandaFragment=BerandaFragment()
        val paketFragment = PaketFragment();
        val orderFragment = OrderFragment();
        val prepaidFragment = PrepaidFragment();

        //default fragment
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container,berandaFragment)
            commit()
        }

        currentFragment(berandaFragment)


        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.fragmentAccount->currentFragment(accountFragment)
                R.id.fragmentBeranda->currentFragment(berandaFragment)
                R.id.fragmentOrder->currentFragment(orderFragment)
                R.id.fragmentPaket->currentFragment(paketFragment)
                R.id.fragmentPrepaid->currentFragment(prepaidFragment)

            }
            true
        }
    }

    private fun currentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container,fragment)
            commit()
        }
}