package com.anwar.finacceltest.ui.bindingadapter

import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.anwar.finacceltest.R
import com.anwar.finacceltest.model.MobileCredit
import java.text.DecimalFormat

/*
* Binding Adapter (BA) for Mobile Credit RV List Adapter.
*/

@BindingAdapter("formattedCreditValue")
fun bindFormattedCreditValue(view: TextView, credit: MobileCredit) {

    val dec = DecimalFormat("#,###.##")
    dec.isDecimalSeparatorAlwaysShown = false
    view.text = dec.format(credit.amount)

}

@BindingAdapter("formattedCreditPrice")
fun bindFormattedCreditPrice(view: Button, credit: MobileCredit) {

    val dec = DecimalFormat("#,###.##")
    dec.isDecimalSeparatorAlwaysShown = false
    view.text = view.context.getString(R.string.lbl_price_idr, dec.format(credit.price))

}

@BindingAdapter("operatorLogo")
fun bindOperatorLogo(view: ImageView, creditRelevantOperator: Int) {

    if (creditRelevantOperator == MobileCredit.INDOSAT) {
        view.setImageResource(R.drawable.logo_indosat)
    } else {
        view.setImageResource(R.drawable.logo_xl)
    }
}