package com.example.cleaningapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView

class HomeActivity : AppCompatActivity() {

    // Fungsi untuk mengganti fragment
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Mengatur padding untuk mengakomodasi sistem bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Menghubungkan TextView dengan ID dari XML
        val txtBeranda: TextView = findViewById(R.id.fragmentBeranda)
        val txtOrder: TextView = findViewById(R.id.fragmentOrder)
        val txtPaket: TextView = findViewById(R.id.fragmentPaket)
        val txtPrepaid: TextView = findViewById(R.id.fragmentPrepaid)
        val txtAccount: TextView = findViewById(R.id.fragmentAccount)

        // Menambahkan click listener untuk setiap TextView
        txtAccount.setOnClickListener {
            replaceFragment(AccountFragment())
        }
        txtBeranda.setOnClickListener {
            replaceFragment(BerandaFragment())
        }
        txtPaket.setOnClickListener {
            replaceFragment(PaketFragment())
        }
        txtOrder.setOnClickListener {
            replaceFragment(OrderFragment())
        }
        txtPrepaid.setOnClickListener {
            replaceFragment(PrepaidFragment())
        }
    }
}
