package aqper.side_project.aop_part5_chapter02.domain

import aqper.side_project.aop_part5_chapter02.data.entitiy.product.ProductEntity
import aqper.side_project.aop_part5_chapter02.data.repository.ProductRepository

internal class GetProductListUseCase(
    private val productRepository: ProductRepository
): UseCase {

    suspend operator fun invoke(): List<ProductEntity> {
        return productRepository.getProductList()
    }

}