package com.example.loansapp.presentation.payLoanScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.core.text.isDigitsOnly
import com.example.loansapp.LoansApp
import com.example.loansapp.R
import com.example.loansapp.presentation.personalCabinetScreen.PersonalCabinetActivity

class PayLoanActivity : AppCompatActivity() {
    private lateinit var payEditText: EditText
    private lateinit var payButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay_loan)


        payEditText = findViewById(R.id.payEditText)
        payButton = findViewById(R.id.payButton)

        val payLoanViewModel : PayLoanViewModel by viewModels()

        payButton.setOnClickListener {
            if (payEditText.text.isDigitsOnly()) {
                val stringPayment:String = payEditText.text.toString()

                payLoanViewModel.payLoan(stringPayment.toInt())
            }
        }

        payLoanViewModel.getStatus().observe(this) { ready ->
            if (ready == true) {
                val intent = Intent(this, PersonalCabinetActivity::class.java)
                startActivity(intent)
            }
        }


    }
}