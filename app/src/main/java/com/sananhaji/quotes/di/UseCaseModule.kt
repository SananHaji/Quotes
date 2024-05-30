package com.sananhaji.quotes.di

import com.sananhaji.domain.repository.QuoteRepository
import com.sananhaji.domain.repository.SettingsRepository
import com.sananhaji.domain.usecase.GetQuotesUseCase
import com.sananhaji.domain.usecase.GetSelectedLanguageUseCase
import com.sananhaji.domain.usecase.LanguageSelectedUseCase
import com.sananhaji.domain.usecase.UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideUseCaseConfiguration(): UseCase.Configuration = UseCase.Configuration(Dispatchers.IO)

    @Provides
    fun provideGetQuotesUseCase(
        configuration: UseCase.Configuration,
        quoteRepository: QuoteRepository
    ): GetQuotesUseCase = GetQuotesUseCase(
        configuration,
        quoteRepository
    )

    @Provides
    fun provideGetPreferencesUseCase(
        configuration: UseCase.Configuration,
        settingsRepository: SettingsRepository
    ): GetSelectedLanguageUseCase = GetSelectedLanguageUseCase(
        configuration,
        settingsRepository
    )

    @Provides
    fun provideLanguageSelectedUseCase(
        configuration: UseCase.Configuration,
        settingsRepository: SettingsRepository
    ): LanguageSelectedUseCase = LanguageSelectedUseCase(
        configuration,
        settingsRepository
    )
}