package com.example.base_android_app.repository

import com.example.base_android_app.base.DataState
import com.example.base_android_app.room.dao.ExampleDao
import com.example.base_android_app.room.model.ExampleEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class ExampleRepository(
    private val exampleDao: ExampleDao
) {
    suspend fun getAllExample(): Flow<DataState<List<ExampleEntity>>> = flow {
        emit(DataState.Loading)
        try {
            emit(DataState.Success(exampleDao.getAll()))
        }
        catch (e: Exception){
            emit(DataState.Error(e))
        }
    }
}