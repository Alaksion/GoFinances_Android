package com.alaksion.gofinances.presentation.main.createtransaction

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.alaksion.gofinances.R
import com.alaksion.gofinances.databinding.FragmentCreateTransactionBinding
import com.alaksion.gofinances.domain.model.TransactionTypes
import com.alaksion.gofinances.presentation.main.dashboard.DashBoardViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class CreateTransactionFrag : Fragment() {

    private lateinit var viewBinding: FragmentCreateTransactionBinding
    private val mViewModel: CreateTransactionViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_create_transaction,
            container,
            false
        )

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListeners()
        setUpSpinner()
    }

    private fun setUpListeners() {
        viewBinding.ivBackButton.setOnClickListener() {
            findNavController().navigate(R.id.a_create_to_dashboard)
        }

        viewBinding.bSubmit.setOnClickListener() {
            submitForm()
            closeKeyBoard(it)
            findNavController().navigate(R.id.a_create_to_dashboard)
        }
    }

    private fun submitForm() {
        mViewModel.createTransaction(
            description = viewBinding.etDescription.text.toString(),
            title = viewBinding.etTitle.text.toString(),
            value = viewBinding.etValue.text.toString(),
            category = viewBinding.sCategory.selectedItem.toString()
        )
    }

    private fun setUpSpinner() {
        viewBinding.sCategory.adapter = ArrayAdapter<TransactionTypes>(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            TransactionTypes.values()
        )
    }

    private fun closeKeyBoard(v: View) {
        val manager = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        manager.hideSoftInputFromWindow(v.windowToken, 0)

    }
}