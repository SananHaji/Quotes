package com.sananhaji.data_local.di

import android.content.Context
import com.sananhaji.data_local.utils.DataStoreUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class LocalDataSourceModule {

    @Provides
    fun provideDataStoreUtils(@ApplicationContext context: Context): DataStoreUtils = DataStoreUtils(context)

}