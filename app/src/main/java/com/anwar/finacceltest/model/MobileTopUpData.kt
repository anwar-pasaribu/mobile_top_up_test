package com.anwar.finacceltest.model

data class MobileTopUpData<T, T2>(
    val mainList: List<T>,
    val secondaryList: List<T2> = listOf()
)