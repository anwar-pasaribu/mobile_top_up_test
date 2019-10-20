package com.anwar.finacceltest.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Promo (
    val id: Long,
    val promoImageUrl: String
) : Parcelable