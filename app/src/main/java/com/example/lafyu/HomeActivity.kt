package com.example.lafyu

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val produkACardView: CardView = findViewById(R.id.produkA)

        produkACardView.setOnClickListener{
            val intent = Intent(this, ProductDetailActivity::class.java)
            startActivity(intent)
        }
        val flashSaleMore: TextView = findViewById(R.id.flashSaleMore)
        flashSaleMore.setOnClickListener{
            val intent = Intent(this,FlashSaleActivity::class.java)
            startActivity(intent)
        }
        val favorite :ImageView = findViewById(R.id.favorite)
        favorite.setOnClickListener {
            val intent = Intent(this, FavoriteProductActivity::class.java)
            startActivity(intent)
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // Handle home action
                    true
                }
                R.id.nav_explore -> {
                    // Handle explore action
                    true
                }
                R.id.nav_cart -> {
                    // Handle cart action
                    true
                }
                R.id.nav_offer -> {
                    // Handle offer action
                    true
                }
                R.id.nav_account -> {
                    // Handle account action
                    true
                }
                else -> false
            }

        }
    }
}