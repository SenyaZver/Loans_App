package com.example.loansapp.presentation.personalCabinetScreen


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.loansapp.R
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loansapp.LoansApp
import com.example.loansapp.domain.entities.Loan
import com.example.loansapp.domain.entities.User
import com.example.loansapp.presentation.loanDetailsScreen.LoanDetailsActivity


class PersonalCabinetActivity : AppCompatActivity() {
    private lateinit var welcomeTextView: TextView
    private lateinit var loansList: RecyclerView
    private var loans: ArrayList<Loan> = ArrayList()

    private var chosenLoan: Loan? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_cabinet)

        val login = intent.extras!!.getString("login")


        val personalCabinetViewModel: PersonalCabinetViewModel by viewModels {PersonalCabinetViewModelFactory(login!!)}

        welcomeTextView = findViewById(R.id.welcomeTextView)
        welcomeTextView.text = "Привет, $login"


        loansList = findViewById(R.id.recyclerView)
        loansList.layoutManager = LinearLayoutManager(this)


        val adapter = personalCabinetViewModel.getAdapter()
        loansList.adapter = adapter

        personalCabinetViewModel.getChosenLoan().observe(this, Observer<Loan?> {chosenLoan ->
            if (chosenLoan!= null) {
                val detailsIntent = Intent(this, LoanDetailsActivity::class.java)

                personalCabinetViewModel.setChosenLoan(null)
                LoansApp.chosenLoanRepository.setChosenLoan(chosenLoan)

                this.startActivity(detailsIntent)
            }

        })

        personalCabinetViewModel.getLoans().observe(this, Observer<ArrayList<Loan>>{ list ->
            adapter.updateItems(list)
        })

        personalCabinetViewModel.getUser().observe(this, Observer<User> { user ->

        })


    }



    fun startDetailsActivity(id: Long) {
        val detailIntent = Intent(this, LoanDetailsActivity::class.java)
    }
}


