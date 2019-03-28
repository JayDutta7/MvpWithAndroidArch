package com.quangnguyen.stackoverflowclient.data

import com.quangnguyen.stackoverflowclient.data.api.HeaderInterceptor
import com.quangnguyen.stackoverflowclient.data.api.QuestionService
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@Module
class ApiServiceModule {

    companion object {

        private const val BASE_URL = "base_url"
    }

    @Provides
    @Named(BASE_URL)
     fun provideBaseUrl(): String {
        return Config.API_HOST
    }

    @Provides
    @Singleton
     fun provideHeaderInterceptor(): HeaderInterceptor {
        return HeaderInterceptor()
    }

    @Provides
    @Singleton
     fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
    }

    @Provides
    @Singleton
     fun provideHttpClient(headerInterceptor: HeaderInterceptor,
                                   httpInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(headerInterceptor)
                .addInterceptor(httpInterceptor)
                .build()
    }

    @Provides
    @Singleton
     fun provideGsonConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
     fun provideRxJavaAdapterFactory(): CallAdapter.Factory {
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    @Singleton
     fun provideRetrofit(@Named(BASE_URL) baseUrl: String, converterFactory: Converter.Factory,
                                 callAdapterFactory: CallAdapter.Factory, client: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(callAdapterFactory)
                .client(client)
                .build()
    }

    @Provides
    @Singleton
     fun provideQuestionService(retrofit: Retrofit): QuestionService {
        return retrofit.create(QuestionService::class.java)
    }


}
