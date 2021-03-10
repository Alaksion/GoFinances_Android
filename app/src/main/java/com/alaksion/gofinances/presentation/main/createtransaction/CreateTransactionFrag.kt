package com.alaksion.gofinances.presentation.main.createtransaction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.alaksion.gofinances.R
import com.alaksion.gofinances.databinding.FragmentCreateTransactionBinding

class CreateTransactionFrag : Fragment() {

    private lateinit var viewBinding : FragmentCreateTransactionBinding

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
    }

    private fun setUpListeners() {
        viewBinding.ivBackButton.setOnClickListener() {
            findNavController().navigate(R.id.a_create_to_dashboard)
        }
    }
}