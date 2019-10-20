package com.anwar.finacceltest.ui.promo

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.anwar.finacceltest.R

class MerchantPromoFragment : Fragment() {

    companion object {
        fun newInstance() = MerchantPromoFragment()
    }

    private lateinit var viewModel: MerchantPromoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.merchant_promo_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MerchantPromoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
