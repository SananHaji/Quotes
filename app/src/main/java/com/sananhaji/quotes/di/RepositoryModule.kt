package com.sananhaji.quotes.di

import com.sananhaji.data_repository.data_source.LocalSettingsSource
import com.sananhaji.data_repository.data_source.RemoteQuoteDataSource
import com.sananhaji.data_repository.repository.QuoteRepositoryImpl
import com.sananhaji.data_repository.repository.SettingsRepositoryImpl
import com.sananhaji.domain.repository.QuoteRepository
import com.sananhaji.domain.repository.SettingsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideQuoteRepository(
        remoteQuoteDataSource: RemoteQuoteDataSource,
        localSettingsSource: LocalSettingsSource,
    ): QuoteRepository = QuoteRepositoryImpl(
        remoteQuoteDataSource,
        localSettingsSource
    )

    @Provides
    fun provideSettingsRepository(
        localSettingsSource: LocalSettingsSource,
    ): SettingsRepository = SettingsRepositoryImpl(
        localSettingsSource
    )

}