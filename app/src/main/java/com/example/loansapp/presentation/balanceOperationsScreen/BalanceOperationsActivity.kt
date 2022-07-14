package com.example.loansapp.presentation.balanceOperationsScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.loansapp.R
import com.example.loansapp.domain.entities.User
import com.example.loansapp.presentation.personalCabinetScreen.PersonalCabinetActivity

class BalanceOperationsActivity : AppCompatActivity() {
    private lateinit var applyButton: Button
    private lateinit var balanceTextView: TextView
    private lateinit var radioGroup: RadioGroup
    private lateinit var addButton: RadioButton
    private lateinit var subtractButton: RadioButton
    private lateinit var amountEditText: EditText
    //TODO remove this
    private var chosenOperation = 0
    private var balance = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_balance_operations)

        radioGroup = findViewById(R.id.radioGroup)
        applyButton = findViewById(R.id.applyOperationButton)
        balanceTextView = findViewById(R.id.balanceTextView)
        addButton = findViewById(R.id.addMoneyRadioButton)
        subtractButton = findViewById(R.id.subtractMoneyRadioButton)
        amountEditText = findViewById(R.id.amountEditText)


        val balanceOperationViewModel : BalanceOperationsViewModel by viewModels()

        addButton.setOnClickListener {
            chosenOperation = 1
        }

        subtractButton.setOnClickListener {
            chosenOperation = 2
        }

        balanceOperationViewModel.getUser().observe(this, Observer<User> { user ->
            balanceTextView.text = "Баланс: " + user.balance.toString()
            balance = user.balance
        })



        applyButton.setOnClickListener {
            var amount = amountEditText.text.toString().toInt()

            var condition: Boolean = (amountEditText.text.toString() != "") && (amount <= balance)

            if ((chosenOperation == 1) && (condition)) {
                balanceOperationViewModel.addMoney(amount)

                val intent = Intent(this, PersonalCabinetActivity::class.java)
                startActivity(intent)
            }

            if ((chosenOperation == 2) && (condition)) {
                balanceOperationViewModel.subtractMoney(amount)

                val intent = Intent(this, PersonalCabinetActivity::class.java)
                startActivity(intent)
            }
        }







    }
}