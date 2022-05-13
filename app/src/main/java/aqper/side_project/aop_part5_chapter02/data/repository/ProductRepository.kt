package aqper.side_project.aop_part5_chapter02.data.repository

import aqper.side_project.aop_part5_chapter02.data.entitiy.product.ProductEntity

interface ProductRepository {

    suspend fun getProductList(): List<ProductEntity>
    suspend fun getLocalProductList(): List<ProductEntity>
    suspend fun insertProductItem(ProductItem: ProductEntity): Long
    suspend fun insertProductList(ProductList: List<ProductEntity>)
    suspend fun updateProductItem(ProductItem: ProductEntity)
    suspend fun getProductItem(intemId: Long): ProductEntity?
    suspend fun deleteAll()
    suspend fun deleteProductItem(id: Long)

}