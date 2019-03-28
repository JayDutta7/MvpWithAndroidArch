package com.quangnguyen.stackoverflowclient

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(context: Application) {
    private val context: Context

    init {
        this.context = context
    }

    @Provides
    @Singleton
     fun provideContext(): Context {
        return context
    }
}
