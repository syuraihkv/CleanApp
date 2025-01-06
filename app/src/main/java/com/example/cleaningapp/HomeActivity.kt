package com.example.cleaningapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView

class HomeActivity : AppCompatActivity() {
    private fun replaceFragment(fragment: Fragment){
    val fragmentManager = supportFragmentManager
    val fragmentTrx = fragmentManager.beginTransaction()
    fragmentTrx.replace(R.id.fragmentContainerView, fragment)
    fragmentTrx.conmit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txtBeranda:TextView = findViewById(R.id.txtBeranda)
        val txtOrder: TextView = findViewById(R.id.txtOrder)
        val txtPaket: TextView =findViewById(R.id.txtPaket)
        val txtPrepaid: TextView = findViewById(R.id.txtPrepaid)
        val txtAccount:TextView = findViewById(R.id.txtAkun)
        val fragmentContainer:FragmentContainerView = findViewById(R.id.fragmentContainerView)

        txtAccount.setOnClickListener{
            replaceFragment(AccountFragment)
        }
        txtBeranda.setOnClickListener{
            replaceFragment(BerandaFragment)
        }
        txtPaket.setOnClickListener{
            replaceFragment(PaketFragment)
        }
        txtOrder.setOnClickListener{
            replaceFragment(OrderFragment)
        }
        txtPrepaid.setOnClickListener{
            replaceFragment(PrepaidFragment)
        }
    }
}