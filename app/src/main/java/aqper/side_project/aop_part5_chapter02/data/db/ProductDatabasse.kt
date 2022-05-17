package aqper.side_project.aop_part5_chapter02.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import aqper.side_project.aop_part5_chapter02.data.db.dao.ProductDao
import aqper.side_project.aop_part5_chapter02.data.entitiy.product.ProductEntity
import aqper.side_project.aop_part5_chapter02.utillity.DateConverter

@Database(
    entities = [ProductEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class ProductDatabasse: RoomDatabase() {
    companion object {
        const val DB_NAME = "ProductDataBase.db"
    }
    abstract fun productDao(): ProductDao
}