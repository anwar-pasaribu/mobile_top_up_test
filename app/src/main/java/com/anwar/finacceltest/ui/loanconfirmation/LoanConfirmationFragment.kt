package com.anwar.finacceltest.ui.loanconfirmation

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.anwar.finacceltest.R

class LoanConfirmationFragment : Fragment() {

    companion object {
        fun newInstance() = LoanConfirmationFragment()
    }

    private lateinit var viewModel: LoanConfirmationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.loan_confirmation_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoanConfirmationViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
