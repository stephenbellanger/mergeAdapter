package com.sbellanger.mergedadapter.ui.main

import androidx.lifecycle.LiveData
import com.sbellanger.mergedadapter.domain.data.FooterEntity
import com.sbellanger.mergedadapter.domain.data.HeaderEntity
import com.sbellanger.mergedadapter.domain.data.MainDataEntity

interface IMainContract {

    interface ViewCapabilites {
        fun initRecyclerView()
        fun showLoader(shouldShow: Boolean)
    }

    interface ViewModel {
        fun observeIsLoading(): LiveData<Boolean>
        fun observeHeader(): LiveData<HeaderEntity>
        fun observeMainData(): LiveData<List<MainDataEntity>>
        fun observeFooter(): LiveData<FooterEntity>
    }

}