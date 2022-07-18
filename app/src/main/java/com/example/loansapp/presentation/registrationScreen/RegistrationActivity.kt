package com.example.loansapp.presentation.registrationScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import com.example.loansapp.R
import com.example.loansapp.presentation.authScreen.AuthActivity

class RegistrationActivity : AppCompatActivity() {
    private lateinit var loginEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var nameEditText: EditText
    private lateinit var passportSeriesEditText: EditText
    private lateinit var passportNumberEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var ptsEditText: EditText

    private lateinit var registerButton: Button

    //not finished, this is temp version for presentation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        init()

        val registrationViewModel : RegistrationViewModel by viewModels()



        registerButton.setOnClickListener {

            val login = loginEditText.text.toString()
            val password = passwordEditText.text.toString()
            val name = nameEditText.text.toString()
            val passportSeries = passportSeriesEditText.text.toString().toInt()
            val passportNumber = passportNumberEditText.text.toString().toInt()
            val email = emailEditText.text.toString()
            val pts = ptsEditText.text.toString()

            val ready : Boolean = ((!login.isEmpty())
                                && (!password.isEmpty())
                                && (!name.isEmpty())
                                && (!passportSeries.toString().isEmpty())
                                && (!passportNumber.toString().isEmpty())
                                && (!email.isEmpty())
                                && (!pts.isEmpty()))


            if (ready) {
                registrationViewModel.register(
                    login,
                    password,
                    name,
                    passportSeries,
                    passportNumber,
                    email,
                    pts
                )


                val intent = Intent(this, AuthActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Bad Info input", Toast.LENGTH_SHORT).show()
            }

        }

    }

    fun init() {
        loginEditText = findViewById(R.id.editTextLogin)
        passwordEditText = findViewById(R.id.editTextPassword)
        nameEditText = findViewById(R.id.editTextName)
        passportSeriesEditText = findViewById(R.id.editTextPassportseries)
        passportNumberEditText = findViewById(R.id.editTextPassportNumber)
        emailEditText = findViewById(R.id.editTextemail)
        ptsEditText = findViewById(R.id.editTextPTS)

        registerButton = findViewById(R.id.registrationButton)
    }

}