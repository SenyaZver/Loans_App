package com.example.loansapp.presentation.personalCabinetScreen

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.loansapp.R
import com.example.loansapp.domain.entities.Loan


class LoansListAdapter(
    private var loansList: ArrayList<Loan>,
    private val loanClickListener: (Loan) -> Unit
) : RecyclerView.Adapter<LoansListAdapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val loanNameTextView: TextView = itemView.findViewById(R.id.loanIdTextView)
        val amountTextView: TextView = itemView.findViewById(R.id.amountTextView)
        val expirationDateTextView: TextView = itemView.findViewById(R.id.expirationDateTextView)

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.loans_list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.loanNameTextView.text = loansList[position].name
        holder.amountTextView.text = loansList[position].amount_left.toString()
        holder.expirationDateTextView.text = loansList[position].expiration_date
        val loan = loansList[position]

        holder.itemView.setOnClickListener {
            loanClickListener(loan)
        }
    }

    override fun getItemCount() = loansList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateItems(newItems: ArrayList<Loan>) {
        loansList = newItems
        notifyDataSetChanged()
    }

}