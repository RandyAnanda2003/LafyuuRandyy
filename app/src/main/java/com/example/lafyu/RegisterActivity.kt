package com.example.lafyu

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registry)

        databaseHelper = DatabaseHelper(this)

        val signUpButton = findViewById<Button>(R.id.signUpButton)
        val signInTextView: TextView = findViewById(R.id.signInTextView)

        signInTextView.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        signUpButton.setOnClickListener {
            val fullNameEditText = findViewById<EditText>(R.id.fullNameEditText)
            val fullname = fullNameEditText.text.toString().trim()

            val emailEditText = findViewById<EditText>(R.id.emailEditText)
            val email = emailEditText.text.toString().trim()

            val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
            val password = passwordEditText.text.toString().trim()

            val confirmPasswordEditText = findViewById<EditText>(R.id.confirmPasswordEditText)
            val confirmPassword = confirmPasswordEditText.text.toString().trim()

            if (password == confirmPassword) {
                val user = User(fullname = fullname, email = email, password = password)
                val result = databaseHelper.addUser(user)
                if (result > -1) {
                    Toast.makeText(this, "User registered successfully!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Registration failed!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
