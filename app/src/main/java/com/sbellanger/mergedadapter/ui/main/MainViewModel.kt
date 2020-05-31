package com.sbellanger.mergedadapter.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.sbellanger.mergedadapter.domain.data.FooterEntity
import com.sbellanger.mergedadapter.domain.data.HeaderEntity
import com.sbellanger.mergedadapter.domain.data.MainDataEntity
import com.sbellanger.mergedadapter.domain.usecase.GetFooterDataUseCase
import com.sbellanger.mergedadapter.domain.usecase.GetHeaderDataUseCase
import com.sbellanger.mergedadapter.domain.usecase.GetMainDataUseCase

class MainViewModel(app: Application) :
    AndroidViewModel(app),
    IMainContract.ViewModel {

    ///////////////////////////////////////////////////////////////////////////
    // DATA
    ///////////////////////////////////////////////////////////////////////////

    private val headerLiveData: MutableLiveData<HeaderEntity> = MutableLiveData()
    private val mainDataLiveData: MutableLiveData<List<MainDataEntity>> = MutableLiveData()
    private val footerLiveData: MutableLiveData<FooterEntity> = MutableLiveData()

    private val isLoading: MediatorLiveData<Boolean> = MediatorLiveData()

    ///////////////////////////////////////////////////////////////////////////
    // INIT
    ///////////////////////////////////////////////////////////////////////////

    init {
        headerLiveData.postValue(GetHeaderDataUseCase().execute())
        mainDataLiveData.postValue(GetMainDataUseCase().execute())
        footerLiveData.postValue(GetFooterDataUseCase().execute())

        isLoading.addSource(headerLiveData) {
            checkIfDataRetrieved()
        }

        isLoading.addSource(mainDataLiveData) {
            checkIfDataRetrieved()
        }

        isLoading.addSource(footerLiveData) {
            checkIfDataRetrieved()
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // CONTRACT IMPLEMENTATION
    ///////////////////////////////////////////////////////////////////////////

    override fun observeIsLoading(): LiveData<Boolean> = isLoading

    override fun observeHeader(): LiveData<HeaderEntity> = headerLiveData

    override fun observeMainData(): LiveData<List<MainDataEntity>> = mainDataLiveData

    override fun observeFooter(): LiveData<FooterEntity> = footerLiveData

    ///////////////////////////////////////////////////////////////////////////
    // PRIVATE METHODS
    ///////////////////////////////////////////////////////////////////////////

    private fun checkIfDataRetrieved() {
        val isReady = headerLiveData.value != null &&
                mainDataLiveData.value != null &&
                footerLiveData.value != null

        if (isLoading.value != !isReady) {
            isLoading.value = !isReady
        }
    }
}
