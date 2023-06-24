package com.example.AppEvent.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.example.AppEvent.data.remote.EventoApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi
            .Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }
    @Singleton
    @Provides
    fun providesEventoApi(moshi: Moshi): EventoApi {
        return Retrofit.Builder()
            .baseUrl("https://eventoapiweb.azurewebsites.net/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(EventoApi::class.java)
    }

}