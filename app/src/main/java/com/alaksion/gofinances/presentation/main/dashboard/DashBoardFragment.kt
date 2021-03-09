package com.alaksion.gofinances.presentation.main.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.alaksion.gofinances.R
import com.alaksion.gofinances.databinding.FragmentDashBoardBinding


class DashBoardFragment : Fragment() {

    private lateinit var viewBinding: FragmentDashBoardBinding
    private lateinit var mViewModel: DashBoardViewModel

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

        mViewModel = ViewModelProvider(this).get(DashBoardViewModel::class.java)

        return viewBinding.root
    }

    override fun onResume() {
        super.onResume()
        mViewModel.loadTransactions()
    }
}