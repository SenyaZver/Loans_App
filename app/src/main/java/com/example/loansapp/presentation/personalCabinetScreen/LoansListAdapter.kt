package com.example.loansapp.presentation.personalCabinetScreen

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.loansapp.R
import com.example.loansapp.domain.entities.Loan

class RecyclerViewAdapter(private var loansList: ArrayList<Loan>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val loanIdTextView: TextView = view.findViewById(R.id.loanIdTextView)
        val amountTextView: TextView = view.findViewById(R.id.amountTextView)
        val expirationDateTextView: TextView = view.findViewById(R.id.expirationDateTextView)
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
    }

    override fun getItemCount() = loansList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateItems(newItems: ArrayList<Loan>) {
        loansList = newItems
        notifyDataSetChanged()
    }

}