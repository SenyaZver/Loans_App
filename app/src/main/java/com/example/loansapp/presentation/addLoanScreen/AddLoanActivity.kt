package com.example.loansapp.presentation.addLoanScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.loansapp.LoansApp
import com.example.loansapp.R
import com.example.loansapp.domain.entities.Loan
import com.example.loansapp.presentation.personalCabinetScreen.PersonalCabinetActivity

class AddLoanActivity : AppCompatActivity() {
    private lateinit var addLoanButton : Button
    private lateinit var calculateAmountButton : Button
    private lateinit var calculatedAmountTextView: TextView

    private lateinit var nameEditText: EditText
    private lateinit var amountEditText: EditText
    private lateinit var dateEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_loan)

        val addLoanViewModel : AddLoanViewModel by viewModels()

        init()



        //that's kinda meh, same as payLoanActivity
        addLoanViewModel.getStatus().observe(this, Observer {ready ->
            if (ready == true) {
                val intent = Intent(this, PersonalCabinetActivity::class.java)
                startActivity(intent)
            }

        })


        calculateAmountButton.setOnClickListener {
            val amount = (amountEditText.text.toString().toDouble()*1.12).toInt()
            calculatedAmountTextView.text = "К выплате: " + amount.toString() + " руб."

        }

        addLoanButton.setOnClickListener {
            val tempId = LoansApp.loansRepository.getLoansList().size.toLong() + 1
            val tempLoan = Loan(
                tempId,
                nameEditText.text.toString(),
                (amountEditText.text.toString().toDouble()*1.12).toInt(),
                (amountEditText.text.toString().toDouble()*1.12).toInt(),
                12.0,
                "15-07-2022",
                dateEditText.text.toString()
            )


            addLoanViewModel.addLoan(tempLoan, amountEditText.text.toString().toInt())
        }


    }

    private fun init() {
        calculateAmountButton = findViewById(R.id.calculateButton)
        addLoanButton = findViewById(R.id.addNewLoanButton)
        calculatedAmountTextView = findViewById(R.id.calculatedAmountTextView)
        nameEditText = findViewById(R.id.nameEditText)
        amountEditText = findViewById(R.id.amountEditText)
        dateEditText = findViewById(R.id.expDateEditText)
    }



}