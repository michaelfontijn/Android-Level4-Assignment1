package com.example.level4_assignment1.repositories

import android.content.Context
import com.example.level4_assignment1.database.ProductDao
import com.example.level4_assignment1.database.ShoppingListRoomDatabase
import com.example.level4_assignment1.models.Product


class ProductRepository(context: Context) {

    //refernece to the dao we need for database communication
    private val productDao: ProductDao

    init {
        //initialize the dao once. We can then use it throughout the entire repo
        val database = ShoppingListRoomDatabase.getDatabase(context)
        productDao = database!!.productDao()
    }

    suspend fun getAllProducts(): List<Product> {
        return productDao.getAllProducts()
    }

    suspend fun insertProduct(product: Product) {
        productDao.insertProduct(product)
    }

    suspend fun deleteProduct(product: Product) {
        productDao.deleteProduct(product)
    }

    //when a kotlin method only has one operation you can use a = sign instead of {}
    suspend fun deleteAllProducts() = productDao.deleteAllProducts()

}




