package com.example.composeadmin.utils

sealed class Resource<T> {

    class Success<T>(val data: T?): Resource<T>()
    class Error(val message: String?): Resource<Nothing>()

}
