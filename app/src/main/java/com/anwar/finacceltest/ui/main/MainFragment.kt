package com.anwar.finacceltest.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.PagerSnapHelper
import com.anwar.finacceltest.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    private val mobileCreditAdapter by lazy { MobileCreditListAdapter() }
    private val topUpPromoListAdapter by lazy { TopUpPromoListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = MainFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        context ?: return binding.root

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        binding.rvTopUpFragment.adapter = mobileCreditAdapter

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.rvTopUpFragmentPromoList)
        binding.rvTopUpFragmentPromoList.adapter = topUpPromoListAdapter

        binding.topUpViewModel = viewModel

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        observeData()
    }

    private fun observeData() {

        viewModel.availableMobileCreditList.observe(this, Observer {
            mobileCreditAdapter.submitList(it)
        })

        viewModel.promoList.observe(this, Observer { promoList ->
            promoList?.let {
                topUpPromoListAdapter.submitList(it)
            }
        })
    }

    private fun initView() {
        // pass by now
    }

}
