package com.sbellanger.mergedadapter.domain.usecase

import com.sbellanger.mergedadapter.R
import com.sbellanger.mergedadapter.domain.data.MainDataEntity

class GetMainDataUseCase {

    fun execute(): List<MainDataEntity> {
        return listOf(
            MainDataEntity(
                imageResId = generateIcon(),
                name = "Bob Sinclair",
                description = "Developper",
                colorRes = generateColor()
            ),
            MainDataEntity(
                imageResId = generateIcon(),
                name = "Henry Mikado",
                description = "Developper",
                colorRes = generateColor()
            ),
            MainDataEntity(
                imageResId = generateIcon(),
                name = "Mike Popy",
                description = "Architecte",
                colorRes = generateColor()
            ),
            MainDataEntity(
                imageResId = generateIcon(),
                name = "Bob Sinclair",
                description = "Developper",
                colorRes = generateColor()
            ),
            MainDataEntity(
                imageResId = generateIcon(),
                name = "Henry Mikado",
                description = "Developper",
                colorRes = generateColor()
            ),
            MainDataEntity(
                imageResId = generateIcon(),
                name = "Mike Popy",
                description = "Architecte",
                colorRes = generateColor()
            ),
            MainDataEntity(
                imageResId = generateIcon(),
                name = "Bob Sinclair",
                description = "Developper",
                colorRes = generateColor()
            ),
            MainDataEntity(
                imageResId = generateIcon(),
                name = "Henry Mikado",
                description = "Developper",
                colorRes = generateColor()
            ),
            MainDataEntity(
                imageResId = generateIcon(),
                name = "Mike Popy",
                description = "Architecte",
                colorRes = generateColor()
            ),
            MainDataEntity(
                imageResId = generateIcon(),
                name = "Bob Sinclair",
                description = "Developper",
                colorRes = generateColor()
            ),
            MainDataEntity(
                imageResId = generateIcon(),
                name = "Henry Mikado",
                description = "Developper",
                colorRes = generateColor()
            ),
            MainDataEntity(
                imageResId = generateIcon(),
                name = "Mike Popy",
                description = "Architecte",
                colorRes = generateColor()
            )
        )
    }

    private fun generateIcon(): Int {
        return when ((1..3).random()) {
            1 -> R.drawable.ic_people_1
            2 -> R.drawable.ic_people_2
            3 -> R.drawable.ic_people_3
            else -> R.drawable.ic_people_1
        }
    }

    private fun generateColor(): Int {
        return when ((1..3).random()) {
            1 -> R.color.alizarin
            2 -> R.color.belize_hole
            3 -> R.color.emeralds
            else -> R.color.alizarin
        }
    }
}