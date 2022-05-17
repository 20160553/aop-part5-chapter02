package aqper.side_project.aop_part5_chapter02.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import aqper.side_project.aop_part5_chapter02.presentation.BaseViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class MainViewModel: BaseViewModel() {

    override fun fetchData(): Job = viewModelScope.launch {  }

    private var _mainStateLiveData = MutableLiveData<MainState>()
    val mainStateLiveData: LiveData<MainState> = _mainStateLiveData

    fun refreshOrderList() = viewModelScope.launch {
        _mainStateLiveData.postValue(MainState.RefreshOrderList)
    }
}