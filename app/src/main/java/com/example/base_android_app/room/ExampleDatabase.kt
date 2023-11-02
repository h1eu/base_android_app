package com.example.base_android_app.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.base_android_app.room.dao.ExampleDao
import com.example.base_android_app.room.model.ExampleEntity

@Database(
    entities = [
        ExampleEntity::class
    ], version = 1
)
abstract class ExampleDatabase : RoomDatabase() {
    abstract fun exampleDao(): ExampleDao

    companion object{
        const val DB_NAME = "example db"
    }
}