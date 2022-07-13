package com.example.loansapp.presentation.personalCabinetScreen

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.loansapp.LoansApp
import com.example.loansapp.R
import com.example.loansapp.domain.entities.Loan


class LoansListAdapter(
    private var loansList: ArrayList<Loan>,

) : RecyclerView.Adapter<LoansListAdapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val loanIdTextView: TextView = itemView.findViewById(R.id.loanIdTextView)
        val amountTextView: TextView = itemView.findViewById(R.id.amountTextView)
        val expirationDateTextView: TextView = itemView.findViewById(R.id.expirationDateTextView)

        fun bindListener(loan: Loan) {
            itemView.setOnClickListener {
                Log.d("debugAdapter", LoansApp.chosenLoanRepository.getChosenLoan()?.amount_left.toString())
                LoansApp.chosenLoanRepository.setChosenLoan(loan)
            }
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.loans_list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.loanIdTextView.text = loansList[position].id.toString()
        holder.amountTextView.text = loansList[position].amount_left.toString()
        holder.expirationDateTextView.text = loansList[position].expiration_date
        val loan = loansList[position]
        holder.bindListener(loan)
    }

    override fun getItemCount() = loansList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateItems(newItems: ArrayList<Loan>) {
        loansList = newItems
        notifyDataSetChanged()
    }

}