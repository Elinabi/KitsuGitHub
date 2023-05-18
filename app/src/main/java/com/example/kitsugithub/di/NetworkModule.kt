package com.example.kitsugithub.di

import com.example.kitsugithub.data.remote.RetrofitClient
import com.example.kitsugithub.data.remote.apiservices.AnimeApiServices
import com.example.kitsugithub.data.remote.apiservices.MangaApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    val retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun provideAnimeApiServices(): AnimeApiServices {
        return retrofitClient.provideAnimeApiServices()
    }

    @Singleton
    @Provides
    fun provideMangaApiServices(): MangaApiServices {
        return retrofitClient.provideMangaApiServices()
    }
}