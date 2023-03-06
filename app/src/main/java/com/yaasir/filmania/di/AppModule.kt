package com.yaasir.filmania.di

import com.yaasir.filmania.data.network.DetailRepositoryImp
import com.yaasir.filmania.data.network.HomeRepositoryImp
import com.yaasir.filmania.data.network.apiservice.FilmaniaApiService
import com.yaasir.filmania.domain.repository.detail.DetailRepository
import com.yaasir.filmania.domain.repository.home.HomeRepository
import com.yaasir.filmania.utils.Configs
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Binds
    abstract fun provideHomeRepository(homeRepositoryImp: HomeRepositoryImp): HomeRepository

    @Binds
    abstract fun provideDetailRepository(detailRepositoryImp: DetailRepositoryImp): DetailRepository

    companion object {
        @Singleton
        @Provides
        fun provideHttpClient(): OkHttpClient {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BASIC
            return OkHttpClient.Builder()
                .addInterceptor(logger)
                .addInterceptor {
                    it.proceed(
                        it.request().newBuilder().url(
                            it.request().url.newBuilder()
                                .addQueryParameter("api_key", Configs.API_KEY).build()
                        ).build()
                    )
                }.build()
        }

        @Singleton
        @Provides
        fun apiServices(client: OkHttpClient): FilmaniaApiService {
            return Retrofit.Builder()
                .baseUrl(Configs.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(FilmaniaApiService::class.java)
        }
    }
}