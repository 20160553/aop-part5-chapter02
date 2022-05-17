package aqper.side_project.aop_part5_chapter02.presentation.detail

import aqper.side_project.aop_part5_chapter02.data.entitiy.product.ProductEntity

sealed class ProductDetailState {

    object UnInitialized: ProductDetailState()

    object Loading: ProductDetailState()

    data class Success(
        val productEntity: ProductEntity
    ): ProductDetailState()

    object Order: ProductDetailState()

    object Error: ProductDetailState()

}