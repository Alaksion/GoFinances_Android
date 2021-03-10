package com.alaksion.gofinances.presentation.main.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.alaksion.gofinances.R
import com.alaksion.gofinances.databinding.FragmentDashBoardBinding
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel


class DashBoardFragment : Fragment() {

    private lateinit var viewBinding: FragmentDashBoardBinding
    private val mViewModel : DashBoardViewModel by viewModel()

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
        setUpListeners()
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
}