package com.github.pacey.launchpal.di.modules

import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.github.pacey.launchpal.di.AppContext
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule(private val context: Context) {

    @Singleton
    @Provides
    @AppContext
    internal fun provideAppContext(): Context {
        return context.applicationContext
    }

    @Provides
    @Singleton
    internal fun providesContext(): Context {
        return context
    }

    @Provides
    @Singleton
    internal fun providesOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(StethoInterceptor())
            .build()
    }

    @Provides
    @Singleton
    internal fun objectMapper(): ObjectMapper {
        return ObjectMapper().findAndRegisterModules()
            .enable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
    }

    @Provides
    @Singleton
    internal fun providesRetrofit(okHttpClient: OkHttpClient, objectMapper: ObjectMapper): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(JacksonConverterFactory.create(objectMapper))
            .baseUrl("https://launchlibrary.net/1.4/")
            .build()
    }
}
