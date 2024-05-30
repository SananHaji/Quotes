package com.sananhaji.data_local.di

import com.sananhaji.data_local.source.LocalSettingsSourceImpl
import com.sananhaji.data_repository.data_source.LocalSettingsSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceBindsModule {

    @Binds
    abstract fun bindLocalSettingsSource(localSettingsSourceImpl: LocalSettingsSourceImpl): LocalSettingsSource

}