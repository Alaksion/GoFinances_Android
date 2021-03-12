package com.alaksion.gofinances.presentation.main.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.alaksion.gofinances.R
import com.alaksion.gofinances.databinding.FragmentDashBoardBinding
import com.alaksion.gofinances.domain.model.Transaction
import com.alaksion.gofinances.domain.model.TransactionTypes
import com.alaksion.gofinances.presentation.main.dashboard.adapter.TransactionListAdapter
import com.alaksion.gofinances.presentation.main.dashboard.listener.TransactionListListener
import com.alaksion.gofinances.shared.extensions.makeMonetaryString
import org.koin.android.viewmodel.ext.android.viewModel


class DashBoardFragment : Fragment() {

    private lateinit var viewBinding: FragmentDashBoardBinding
    private val mViewModel: DashBoardViewModel by viewModel()

    private val recylerAdapter = TransactionListAdapter(object : TransactionListListener {

    })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_dash_board,
            container,
            false
        )
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        setUpListeners()
        setUpObservers()
    }

    override fun onResume() {
        super.onResume()
        mViewModel.loadTransactions()
    }

    private fun setUpListeners() {
        viewBinding.ivAddTransaction.setOnClickListener() {
            findNavController().navigate(R.id.a_dashboard_to_create)
        }
    }

    private fun setUpObservers() {
        mViewModel.transactionList.observe(viewLifecycleOwner, Observer {
            setCardValues(it)
            recylerAdapter.updateList(it)
        })
    }

    private fun setUpRecyclerView() {
        viewBinding.rvTransactions.layoutManager = LinearLayoutManager(context)

        viewBinding.rvTransactions.adapter = recylerAdapter

    }

    private fun setCardValues(transactionList: List<Transaction>) {
        var incomes = 0.0
        var outcomes = 0.0
        var total = 0.0

        transactionList.forEach {
            if (it.category == TransactionTypes.INCOME.getText()) {
                incomes += it.value
            } else {
                outcomes += it.value
            }
        }

        total = incomes - outcomes

        viewBinding.tvIncome.text = incomes.toString().makeMonetaryString()
        viewBinding.tvOutcome.text = outcomes.toString().makeMonetaryString()
        viewBinding.tvTotal.text = total.toString().makeMonetaryString()
    }
}