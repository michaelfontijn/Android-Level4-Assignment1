package com.example.level4_assignment1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.level4_assignment1.models.Product

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class ShoppingListRoomDatabase : RoomDatabase() {

    //here we link the Dao to our db class
    abstract fun productDao(): ProductDao

    //static section
    companion object {
        private const val DATABASE_NAME = "SHOPPING_LIST_DATABASE"

        @Volatile
        private var shoppingListRoomDatabaseInstance: ShoppingListRoomDatabase? = null

        //function to initialize/ build the database and dao and return a reference to the initialized Db object
        fun getDatabase(context: Context): ShoppingListRoomDatabase? {
            if (shoppingListRoomDatabaseInstance == null) {
                synchronized(ShoppingListRoomDatabase::class.java) {
                    if (shoppingListRoomDatabaseInstance == null) {
                        shoppingListRoomDatabaseInstance =
                            Room.databaseBuilder(context.applicationContext,ShoppingListRoomDatabase::class.java, DATABASE_NAME).build()
                    }
                }
            }
            return shoppingListRoomDatabaseInstance
        }
    }

}
