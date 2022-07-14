package com.example.loansapp.presentation.personalCabinetScreen


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
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
    private lateinit var balanceTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_cabinet)

        val personalCabinetViewModel: PersonalCabinetViewModel by viewModels()

        loansList = findViewById(R.id.recyclerView)
        loansList.layoutManager = LinearLayoutManager(this)

        val adapter = LoansListAdapter (ArrayList<Loan>()) { it ->
            personalCabinetViewModel.loanItemClicked(
                it
            )
        }
        loansList.adapter = adapter
        personalCabinetViewModel.loanClickEvent.observe(this, Observer(::loanClicked))

        balanceTextView = findViewById(R.id.balanceTextView)


        personalCabinetViewModel.getUser().observe(this, Observer<User> { user->
            balanceTextView.text = "Баланс: " + user.balance.toString() + " руб."
        })

        personalCabinetViewModel.getLoans().observe(this, Observer<ArrayList<Loan>>{ list ->
            adapter.updateItems(list)
        })



    }


    private fun loanClicked(loan: Loan) {
        val detailsIntent = Intent(this, LoanDetailsActivity::class.java)

        LoansApp.chosenLoanRepository.setChosenLoan(loan)

        this.startActivity(detailsIntent)
    }


}


