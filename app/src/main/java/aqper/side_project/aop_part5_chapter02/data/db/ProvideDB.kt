package aqper.side_project.aop_part5_chapter02.data.db

import android.content.Context
import androidx.room.Room

internal fun provideDB(context: Context): ProductDatabasse =
    Room.databaseBuilder(context, ProductDatabasse::class.java, ProductDatabasse.DB_NAME).build()

internal fun provideToDoDao(databasse: ProductDatabasse) = databasse.productDao()