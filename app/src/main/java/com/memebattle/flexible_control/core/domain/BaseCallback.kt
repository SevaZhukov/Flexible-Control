package com.memebattle.flexible_control.core.domain

interface BaseCallback<T> {
    fun onSuccess(result: T)
    fun onError(error: Throwable)
}