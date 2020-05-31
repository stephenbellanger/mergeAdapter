package com.sbellanger.mergedadapter.domain.data

import androidx.annotation.DrawableRes

data class HeaderEntity(
    val title: String,
    val temperature: String,
    @DrawableRes val weather: Int
)