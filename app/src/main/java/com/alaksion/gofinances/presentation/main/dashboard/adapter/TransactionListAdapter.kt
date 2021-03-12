package com.alaksion.gofinances.presentation.main.dashboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alaksion.gofinances.R
import com.alaksion.gofinances.domain.model.Transaction
import com.alaksion.gofinances.presentation.main.dashboard.listener.TransactionListListener
import com.alaksion.gofinances.presentation.main.dashboard.viewholder.TransactionListViewHolder

class TransactionListAdapter(
    private val listListener: TransactionListListener
) :
    RecyclerView.Adapter<TransactionListViewHolder>() {

    private var transactionList: List<Transaction> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionListViewHolder {
        val item =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.transaction_list_item, parent, false)

        return TransactionListViewHolder(item, listListener)
    }

    override fun getItemCount(): Int {
        return transactionList.size
    }

    override fun onBindViewHolder(holder: TransactionListViewHolder, position: Int) {
        holder.bindData(transactionList[position])
    }

    fun updateList(list: List<Transaction>) {
        this.transactionList = list
        notifyDataSetChanged()
    }
}