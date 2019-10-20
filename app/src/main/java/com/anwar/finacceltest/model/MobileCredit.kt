package com.anwar.finacceltest.model

data class MobileCredit(
    val id: Long,
    val amount: Double,
    val price: Double,
    val operator: Int = INDOSAT,
    val description: String = ""
) {
    companion object {
        const val INDOSAT = 0
        const val XL = 1
    }
}