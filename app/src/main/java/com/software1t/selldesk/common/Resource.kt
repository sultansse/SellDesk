package com.software1t.selldesk.common

sealed class Resource<out T> {
    class Success<T>(val data: T) : Resource<T>()
    class Error(val exception : Exception) : Resource<Nothing>()
    object Empty : Resource<Nothing>()
}