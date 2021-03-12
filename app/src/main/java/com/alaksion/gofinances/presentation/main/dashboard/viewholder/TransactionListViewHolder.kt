package com.alaksion.gofinances.presentation.main.dashboard.viewholder

import android.media.Image
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alaksion.gofinances.R
import com.alaksion.gofinances.domain.model.Transaction
import com.alaksion.gofinances.presentation.main.dashboard.listener.TransactionListListener
import com.alaksion.gofinances.shared.extensions.makeMonetaryString

class TransactionListViewHolder(
    view: View,
    val listener: TransactionListListener
) :
    RecyclerView.ViewHolder(view) {

    private val transactionTitle: TextView = view.findViewById(R.id.tv_title)
    private val transactionValue: TextView = view.findViewById(R.id.tv_value)
    private val transactionCategoryIcon: ImageView = view.findViewById(R.id.iv_transaction_type_icon)

    fun bindData(transaction: Transaction) {

        transactionTitle.text = transaction.title
        transactionValue.text = transaction.value.toString().makeMonetaryString()
        transactionCategoryIcon.setImageResource(R.drawable.ic_outcome)
    }
}