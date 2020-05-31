package com.sbellanger.mergedadapter.domain.data

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

data class MainDataEntity(
    @DrawableRes val imageResId: Int,
    val name: String,
    val description: String,
    @ColorRes val colorRes: Int
)