package aqper.side_project.aop_part5_chapter02.presentation

import kotlinx.coroutines.Job

internal abstract class BaseViewModel {
    abstract fun fetchData(): Job
}