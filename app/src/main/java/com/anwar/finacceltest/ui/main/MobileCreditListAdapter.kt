package com.anwar.finacceltest.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.anwar.finacceltest.databinding.RowCreditAmountBinding
import com.anwar.finacceltest.model.MobileCredit

class MobileCreditListAdapter :
    ListAdapter<MobileCredit, RecyclerView.ViewHolder>(MobileCreditDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MobileCreditViewHolder(
            RowCreditAmountBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mobileCredit = getItem(position)
        configureMobileCreditView(holder as MobileCreditViewHolder, mobileCredit)
    }

    private fun configureMobileCreditView(
        holder: MobileCreditViewHolder,
        mobileCredit: MobileCredit
    ) {

        holder.bind(mobileCredit)

    }

    inner class MobileCreditViewHolder(
        private val binding: RowCreditAmountBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.setSelectMobileCreditAmount {
                binding.credit?.let { mobileCredit ->
                    it.findNavController().navigate(
                        MainFragmentDirections.actionOpenLoanConfirmation()
                    )
                }
            }
        }

        fun bind(item: MobileCredit) {
            binding.apply {
                credit = item
                executePendingBindings()
            }
        }
    }
}

private class MobileCreditDiffCallback : DiffUtil.ItemCallback<MobileCredit>() {

    override fun areItemsTheSame(oldItem: MobileCredit, newItem: MobileCredit): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MobileCredit, newItem: MobileCredit): Boolean {
        return oldItem == newItem
    }
}
