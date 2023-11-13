package com.example.base_android_app.base

sealed class DataState<out R> {
    data class Success<out T>(val data: T): DataState<T>()

    data class Error<out T>(val ex: T): DataState<Nothing>()

    data object Loading: DataState<Nothing>()
}