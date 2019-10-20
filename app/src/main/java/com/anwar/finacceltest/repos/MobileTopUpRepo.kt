package com.anwar.finacceltest.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.anwar.finacceltest.model.MobileCredit
import com.anwar.finacceltest.model.MobileTopUpData
import com.anwar.finacceltest.model.Promo

object MobileTopUpRepo {

    private val fakePromos = listOf(
        Promo(1L, "https://pbs.twimg.com/media/EHELo3nW4AABVuu?format=jpg&name=large"),
        Promo(2L, "https://pbs.twimg.com/media/EHI_laiXUAAHqtp?format=jpg&name=large"),
        Promo(3L, "https://tvlk.imgix.net/imageResource/2019/10/15/1571122695059-431b8a948869d9153491cd26e6f304d6.jpeg?auto=compress%2Cformat&cs=srgb&fm=pjpg&ixlib=java-1.1.12&q=75")
    )

    private val fakeAvailableMobileCreditList = listOf(
        MobileCredit(1L, 25000.0, 25000.0),
        MobileCredit(2L, 50000.0, 50000.0),
        MobileCredit(3L, 100000.0, 100000.0),
        MobileCredit(4L, 150000.0, 150000.0),
        MobileCredit(5L, 200000.0, 195000.0),
        MobileCredit(6L, 25000.0, 25000.0, operator = MobileCredit.XL),
        MobileCredit(7L, 50000.0, 50000.0, operator = MobileCredit.XL),
        MobileCredit(8L, 100000.0, 100000.0, operator = MobileCredit.XL),
        MobileCredit(9L, 150000.0, 150000.0, operator = MobileCredit.XL),
        MobileCredit(10L, 200000.0, 195000.0, operator = MobileCredit.XL)
    )

    fun getAvailableCreditAmount(operator: String) : LiveData<List<MobileCredit>> {

        println("[Repo] Target operator: $operator")

        val mutableOpCreditList = MutableLiveData<List<MobileCredit>>()

        if (operator.length < 4) return MutableLiveData<List<MobileCredit>>(listOf())

        val operatorType = if (operator.contains("0878")) {
            MobileCredit.XL
        } else {
            MobileCredit.INDOSAT
        }

        mutableOpCreditList.value = fakeAvailableMobileCreditList.filter {
            it.operator == operatorType
        }

        return mutableOpCreditList
    }

    fun getOperatorType(phoneNumber: String): Int = if (phoneNumber.contains("0878")) {
        MobileCredit.XL
    } else {
        MobileCredit.INDOSAT
    }

    fun getPromoList(phoneNumber: String): LiveData<List<Promo>> {

        if (phoneNumber.length < 4) return MutableLiveData<List<Promo>>(listOf())

        // TODO For now return all fake promo
        return MutableLiveData<List<Promo>>(fakePromos)
    }

}