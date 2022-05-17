package aqper.side_project.aop_part5_chapter02.domain

import aqper.side_project.aop_part5_chapter02.data.entitiy.product.ProductEntity
import aqper.side_project.aop_part5_chapter02.data.repository.ProductRepository

internal class OrderProductItemUseCase(
    private val productRepository: ProductRepository
): UseCase {

    suspend operator fun invoke(productEntity: ProductEntity): Long {
        return productRepository.insertProductItem(productEntity)
    }

}