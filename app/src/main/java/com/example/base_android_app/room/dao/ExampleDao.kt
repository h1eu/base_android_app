package com.example.base_android_app.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.base_android_app.room.model.ExampleEntity

@Dao
interface ExampleDao {
    @Query("SELECT * FROM ExampleEntity")
    suspend fun getAll(): List<ExampleEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertExample(exampleEntity: ExampleEntity)

    @Delete
    suspend fun deleteExample(exampleEntity: ExampleEntity)

    @Update
    suspend fun updateExample(exampleEntity: ExampleEntity)

}