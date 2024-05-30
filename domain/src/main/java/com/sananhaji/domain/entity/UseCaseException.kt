package com.sananhaji.domain.entity

sealed class UseCaseException(cause: Throwable) : Throwable(cause) {

    class QuoteException(cause: Throwable) : UseCaseException(cause)

    class UnknownException(cause: Throwable) : UseCaseException(cause)


    companion object {

        fun createFromThrowable(throwable: Throwable): UseCaseException {
            return if (throwable is UseCaseException) throwable else UnknownException(throwable)
        }
    }
}