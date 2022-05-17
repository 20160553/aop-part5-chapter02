package aqper.side_project.aop_part5_chapter02.di

import aqper.side_project.aop_part5_chapter02.data.db.provideDB
import aqper.side_project.aop_part5_chapter02.data.db.provideToDoDao
import aqper.side_project.aop_part5_chapter02.data.network.buildOkHttpClient
import aqper.side_project.aop_part5_chapter02.data.network.provideGsonConverterFactory
import aqper.side_project.aop_part5_chapter02.data.network.provideProductApiService
import aqper.side_project.aop_part5_chapter02.data.network.provideProductRetrofit
import aqper.side_project.aop_part5_chapter02.data.repository.DefaultProductRepository
import aqper.side_project.aop_part5_chapter02.data.repository.ProductRepository
import aqper.side_project.aop_part5_chapter02.domain.GetProductItemUseCase
import aqper.side_project.aop_part5_chapter02.domain.GetProductListUseCase
import aqper.side_project.aop_part5_chapter02.domain.OrderProductItemUseCase
import aqper.side_project.aop_part5_chapter02.presentation.detail.ProductDetailViewModel
import aqper.side_project.aop_part5_chapter02.presentation.list.ProductListViewModel
import aqper.side_project.aop_part5_chapter02.presentation.main.MainViewModel
import aqper.side_project.aop_part5_chapter02.presentation.profile.ProfileViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    //ViewModels
    viewModel { MainViewModel() }
    viewModel { ProfileViewModel() }
    viewModel { ProductListViewModel(get()) }
    viewModel { (productId: Long) -> ProductDetailViewModel(productId, get(), get()) }


    //Coroutines Dispatcher
    single { Dispatchers.Main }
    single { Dispatchers.IO }

    //UseCase
    factory { GetProductItemUseCase(get()) }
    factory { GetProductListUseCase(get()) }
    factory { OrderProductItemUseCase(get()) }

    //Repositories
    single<ProductRepository> { DefaultProductRepository(get(), get(), get()) }

    single { provideGsonConverterFactory() }

    single { buildOkHttpClient() }

    single { provideProductRetrofit(get(), get()) }

    single { provideProductApiService(get()) }

    //Database
    single { provideDB(androidApplication()) }
    single { provideToDoDao(get()) }

}