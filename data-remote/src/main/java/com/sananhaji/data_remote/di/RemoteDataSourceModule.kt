package com.sananhaji.data_remote.di

import com.sananhaji.data_remote.source.RemoteQuoteDataSourceImpl
import com.sananhaji.data_repository.data_source.RemoteQuoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun bindPostDataSource(postDataSourceImpl: RemoteQuoteDataSourceImpl): RemoteQuoteDataSource

}