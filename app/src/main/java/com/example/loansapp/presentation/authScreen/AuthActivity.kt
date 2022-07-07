package com.example.loansapp.presentation.authScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import com.example.loansapp.R
import com.example.loansapp.domain.entities.Status
import com.example.loansapp.presentation.personalCabinetScreen.PersonalCabinetActivity

class AuthActivity : AppCompatActivity() {

    private lateinit var loginEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var authButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        loginEditText = findViewById(R.id.editTextLogin)
        passwordEditText = findViewById(R.id.editTextPassword)
        authButton = findViewById(R.id.authButton)


        val authViewModel: AuthViewModel by viewModels()

//        authViewModel.getStatus().observe(this, Observer<Status> { status ->
//            when (status) {
//                Status.SUCCESSFUL -> Toast.makeText(this, "Authorisation successful", Toast.LENGTH_SHORT).show()
//                Status.NOT_SUCCESSFUL -> Toast.makeText(this, "Authorisation not successful", Toast.LENGTH_LONG).show()
//                else -> {}
//            }
//        })

        authButton.setOnClickListener {
            val login = loginEditText.text.toString()
            val password = passwordEditText.text.toString()
            val status = authViewModel.loadStatus(login, password)

            if (status == Status.SUCCESSFUL) {
                Toast.makeText(this, "Authorisation successful", Toast.LENGTH_SHORT).show()
                val authIntent = Intent(this, PersonalCabinetActivity::class.java)
                authIntent.putExtra("login", login)

                this.startActivity(authIntent)
            }
            if (status == Status.NOT_SUCCESSFUL) {
                Toast.makeText(this, "Authorisation not successful", Toast.LENGTH_LONG).show()
            }
        }





    }
}

