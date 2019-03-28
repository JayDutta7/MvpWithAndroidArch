package com.quangnguyen.stackoverflowclient.data

import com.quangnguyen.stackoverflowclient.AppModule
import com.quangnguyen.stackoverflowclient.data.repository.QuestionRepository

import javax.inject.Singleton

import dagger.Component

@Singleton
@Component(modules = [QuestionRepositoryModule::class, AppModule::class, ApiServiceModule::class, DatabaseModule::class])
interface QuestionRepositoryComponent {
    fun provideQuestionRepository(): QuestionRepository
}
