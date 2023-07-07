package com.example.timer_bottomnav_dependencyinjection.di

import com.example.timer_bottomnav_dependencyinjection.data.remote.HolidayCall
import com.example.timer_bottomnav_dependencyinjection.data.remote.ApiDetail
import com.example.timer_bottomnav_dependencyinjection.data.repository.Repository
import com.example.timer_bottomnav_dependencyinjection.data.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module//state current class is a model
@InstallIn(SingletonComponent::class)//inform the scope of class or items inside
class AppModule {
    @Provides
        //fun name does not matter
    fun provideOkHttInstance():OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }
    @Provides
    fun provideRetrofitInstance(
        client: OkHttpClient
    ): Retrofit{
        return Retrofit.Builder()
            .baseUrl(ApiDetail.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
    @Provides
    fun provideAPI(
        retrofit: Retrofit
    ):HolidayCall{
        return retrofit.create(HolidayCall::class.java )
    }
    @Provides
    fun provdeRepository(
        holidayCall: HolidayCall
    ):Repository {
        return RepositoryImpl(holidayCall )
    }
}