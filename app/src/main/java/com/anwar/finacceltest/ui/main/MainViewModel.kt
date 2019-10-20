package com.anwar.finacceltest.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations.map
import androidx.lifecycle.Transformations.switchMap
import androidx.lifecycle.ViewModel
import com.anwar.finacceltest.model.MobileCredit
import com.anwar.finacceltest.repos.MobileTopUpRepo

class MainViewModel : ViewModel() {


    val phoneNumber = MutableLiveData<String>()

    val availableMobileCreditList: LiveData<List<MobileCredit>> = switchMap(phoneNumber) {
        MobileTopUpRepo.getAvailableCreditAmount(it)
    }

    val promoList = switchMap(phoneNumber) {
        MobileTopUpRepo.getPromoList(it)
    }

    val operatorType: LiveData<Int> = map(phoneNumber) {
        MobileTopUpRepo.getOperatorType(it)
    }


    init {
        availableMobileCreditList.observeForever {
            println("Forever observer. List size: ${it.size}")
        }
    }

}
