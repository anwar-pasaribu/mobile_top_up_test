package com.anwar.finacceltest.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.anwar.finacceltest.databinding.RowCreditAmountBinding
import com.anwar.finacceltest.databinding.RowMobileTopUpPromoItemBinding
import com.anwar.finacceltest.model.MobileCredit
import com.anwar.finacceltest.model.Promo

class TopUpPromoListAdapter :
    ListAdapter<Promo, RecyclerView.ViewHolder>(PromoDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PromoItemViewHolder(
            RowMobileTopUpPromoItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val promoItem = getItem(position)
        configurePromoItemView(holder as PromoItemViewHolder, promoItem)
    }

    private fun configurePromoItemView(
        holder: PromoItemViewHolder,
        mobileCredit: Promo
    ) {

        holder.bind(mobileCredit)

    }

    inner class PromoItemViewHolder(
        private val binding: RowMobileTopUpPromoItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.setOnClickPromo {
                binding.promoItem?.let { promoItem ->
                    it.findNavController().navigate(
                        MainFragmentDirections.actionOpenMerchantPromo(promoItem)
                    )
                }
            }
        }

        fun bind(item: Promo) {
            binding.apply {
                promoItem = item
                executePendingBindings()
            }
        }
    }
}

private class PromoDiffCallback : DiffUtil.ItemCallback<Promo>() {

    override fun areItemsTheSame(oldItem: Promo, newItem: Promo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Promo, newItem: Promo): Boolean {
        return oldItem == newItem
    }
}
