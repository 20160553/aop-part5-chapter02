package aqper.side_project.aop_part5_chapter02.presentation.main

import aqper.side_project.aop_part5_chapter02.presentation.BaseViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class MainViewModel: BaseViewModel() {

    override fun fetchData(): Job = viewModelScope.launch {  }
}