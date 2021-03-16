package com.alaksion.gofinances.presentation.main.dashboard.viewholder

import android.app.AlertDialog
import android.media.Image
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.alaksion.gofinances.R
import com.alaksion.gofinances.domain.model.Transaction
import com.alaksion.gofinances.domain.model.TransactionTypes
import com.alaksion.gofinances.presentation.main.dashboard.listener.TransactionListListener
import com.alaksion.gofinances.shared.extensions.makeMonetaryString

class TransactionListViewHolder(
    view: View,
    val listener: TransactionListListener
) :
    RecyclerView.ViewHolder(view) {

    private val transactionTitle: TextView = view.findViewById(R.id.tv_title)
    private val transactionValue: TextView = view.findViewById(R.id.tv_value)
    private val transactionCategoryIcon: ImageView =
        view.findViewById(R.id.iv_transaction_type_icon)
    private val transacitonContainer: ConstraintLayout = view.findViewById(R.id.cl_content)

    fun bindData(transaction: Transaction) {

        transactionTitle.text = transaction.title
        transactionValue.text = transaction.value.toString().makeMonetaryString()
        transactionCategoryIcon.setImageResource(getTransactionIconBasedOnType(transaction))

        transacitonContainer.setOnLongClickListener {
            AlertDialog.Builder(itemView.context)
                .setTitle("Remoção de transação")
                .setMessage("Tem certeza que deseja deletar transação?")
                .setPositiveButton("Remover") { _, _ ->
                    listener.onHoldClick(transaction)
                }
                .setNeutralButton("Cancelar", null)
                .show()
            true
        }
    }

    private fun getTransactionIconBasedOnType(transaction: Transaction): Int {
        return if (transaction.category == TransactionTypes.INCOME.getText()) {
            R.drawable.ic_income
        } else {
            R.drawable.ic_outcome
        }
    }
}