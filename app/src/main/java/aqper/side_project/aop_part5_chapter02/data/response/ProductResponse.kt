package aqper.side_project.aop_part5_chapter02.data.response

import aqper.side_project.aop_part5_chapter02.data.entitiy.product.ProductEntity
import java.util.*

data class ProductResponse(
    val id: Long,
    val createdAt: Long,
    val productName: String,
    val productPrice: String,
    val productImage: String,
    val productType: String,
    val productIntroductionImage: String
) {
    fun toEntity(): ProductEntity =
        ProductEntity(
            id = id.toLong(),
            createdAt = Date(createdAt),
            productName = productName,
            productPrice = productPrice.toDouble().toInt(),
            productImage = productImage,
            productType = productType,
            productIntroductionImage = productIntroductionImage
        )
}
