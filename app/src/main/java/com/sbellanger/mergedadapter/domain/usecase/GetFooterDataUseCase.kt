package com.sbellanger.mergedadapter.domain.usecase

import com.sbellanger.mergedadapter.domain.data.FooterEntity

class GetFooterDataUseCase {

    fun execute(): FooterEntity {
        return FooterEntity(
            name = "Stephen Bellanger",
            email = "stephenbellanger@gmail.com"
        )
    }

}