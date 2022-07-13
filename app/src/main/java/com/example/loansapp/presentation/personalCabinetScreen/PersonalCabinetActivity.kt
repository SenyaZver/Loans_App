package com.example.loansapp.presentation.personalCabinetScreen


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.loansapp.R
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loansapp.LoansApp
import com.example.loansapp.domain.entities.Loan
import com.example.loansapp.presentation.loanDetailsScreen.LoanDetailsActivity


class PersonalCabinetActivity : AppCompatActivity() {
    private lateinit var welcomeTextView: TextView
    private lateinit var loansList: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_cabinet)

        val personalCabinetViewModel: PersonalCabinetViewModel by viewModels()

        loansList = findViewById(R.id.recyclerView)
        loansList.layoutManager = LinearLayoutManager(this)
        val adapter = LoansListAdapter(personalCabinetViewModel.getLoans()!!)
        loansList.adapter = adapter

        personalCabinetViewModel.getLoansLiveData().observe(this, Observer<ArrayList<Loan>>{ list ->
            adapter.updateItems(list)
        })


        personalCabinetViewModel.getChosenLoan().observe(this, Observer<Loan?> {chosenLoan ->
            if (chosenLoan!= null) {
                val detailsIntent = Intent(this, LoanDetailsActivity::class.java)

                personalCabinetViewModel.setChosenLoan(null)
                LoansApp.chosenLoanRepository.setChosenLoan(chosenLoan)

                this.startActivity(detailsIntent)
            }
        })

        val debugButton : Button = findViewById(R.id.debugbutton)
        debugButton.setOnClickListener {
            Log.d("debug", personalCabinetViewModel.getChosenLoan().value?.amount_left.toString())
        }

    }

}


