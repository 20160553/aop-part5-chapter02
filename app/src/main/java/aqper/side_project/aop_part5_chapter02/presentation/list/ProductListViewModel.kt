package aqper.side_project.aop_part5_chapter02.presentation.list

import androidx.lifecycle.viewModelScope
import aqper.side_project.aop_part5_chapter02.presentation.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class ProductListViewModel: BaseViewModel() {
    override fun fetchData(): Job = viewModelScope.launch{}
}