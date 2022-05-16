package aqper.side_project.aop_part5_chapter02.presentation.list

import aqper.side_project.aop_part5_chapter02.data.entitiy.product.ProductEntity

sealed class ProductListState {

    object UnInitialized: ProductListState()

    object Loading: ProductListState()

    data class Success(
        val productList: List<ProductEntity>
    ): ProductListState()

    object Error: ProductListState()

}