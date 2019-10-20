package com.anwar.finacceltest.ui.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.anwar.finacceltest.R
import com.anwar.finacceltest.model.Promo
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

/*
* Binding Adapter (BA) for Top Up Promo RV List Adapter.
*/

@BindingAdapter("promoListImage")
fun bindGalleryListItemImage(view: ImageView, promo: Promo) {

    val roundedVal = view.context.resources.getDimensionPixelOffset(R.dimen.shape_radius_m)

    Glide.with(view.context)
        .asBitmap()
        .load(promo.promoImageUrl)
        .transform(CenterCrop(), RoundedCorners(roundedVal))
        .transition(BitmapTransitionOptions.withCrossFade())
        .into(view)
}