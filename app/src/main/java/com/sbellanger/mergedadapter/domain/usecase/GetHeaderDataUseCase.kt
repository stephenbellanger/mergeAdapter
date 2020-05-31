package com.sbellanger.mergedadapter.domain.usecase

import com.sbellanger.mergedadapter.R
import com.sbellanger.mergedadapter.domain.data.HeaderEntity

class GetHeaderDataUseCase {

    fun execute(): HeaderEntity {
        return HeaderEntity(
            title = "Liste des développeurs disponible",
            temperature = "22°",
            weather = R.drawable.ic_sun
        )
    }
}