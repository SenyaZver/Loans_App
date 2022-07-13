package com.example.loansapp.presentation.loanDetailsScreen

import android.app.Application
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.loansapp.LoansApp
import com.example.loansapp.R
import com.example.loansapp.data.ChosenLoanRepository
import com.example.loansapp.presentation.payLoanScreen.PayLoanActivity

class LoanDetailsActivity : AppCompatActivity() {
    private lateinit var loanNameTextView: TextView
    private lateinit var loanIdTextView: TextView
    private lateinit var loanAmountTextView: TextView
    private lateinit var loanAmountLeftTextView: TextView
    private lateinit var loanRateTextView: TextView
    private lateinit var loanStartDateTextView: TextView
    private lateinit var loanExpDateTextView: TextView

    private lateinit var payButton: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loan_details)

        val loanDetailsViewModel : LoanDetailViewModel by viewModels {LoanDetailsViewModelFactory(LoansApp.chosenLoanRepository, "")}
        init(loanDetailsViewModel)


    }



    fun init(viewModel : LoanDetailViewModel) {
        payButton = findViewById(R.id.detailsPayButton)
        loanNameTextView = findViewById(R.id.loanNameTextView)
        loanIdTextView = findViewById(R.id.loanIdTextView)
        loanAmountTextView = findViewById(R.id.loanAmountTextView)
        loanAmountLeftTextView = findViewById(R.id.loanAmountLeftTextView)
        loanRateTextView = findViewById(R.id.loanRateTextView)
        loanStartDateTextView = findViewById(R.id.loanStartDateTextView)
        loanExpDateTextView = findViewById(R.id.loanExpDateTextView)


        viewModel.getName().observe(this, Observer<String> { name ->
            loanNameTextView.text = name
        })
        viewModel.getId().observe(this, Observer<Long> { id ->
            loanIdTextView.text = "ID займа: " + id.toString()
        })
        viewModel.getAmount().observe(this, Observer<Int> { amount ->
            loanAmountTextView.text = "Общая сумма: " + amount.toString() + " руб."
        })
        viewModel.getAmountLeft().observe(this, Observer<Int> { amountLeft ->
            loanAmountLeftTextView.text = "Осталось выплатить: " + amountLeft.toString() + " руб."
        })
        viewModel.getRate().observe(this, Observer<Double> { rate ->
            loanRateTextView.text = "Процентная ставка: " + rate.toString() + "%"
        })
        viewModel.getStartDate().observe(this, Observer<String> { date ->
            loanStartDateTextView.text = "Дата начала: " + date
        })
        viewModel.getExpDate().observe(this, Observer<String> { date ->
            loanExpDateTextView.text = "Дата окончания: " + date
        })

        payButton.setOnClickListener {
            val intent = Intent(this, PayLoanActivity::class.java)
            startActivity(intent)
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        LoansApp.chosenLoanRepository.setChosenLoan(null)
    }
}