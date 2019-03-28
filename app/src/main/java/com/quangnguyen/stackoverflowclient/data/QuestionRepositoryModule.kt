package com.quangnguyen.stackoverflowclient.data

import com.quangnguyen.stackoverflowclient.data.repository.Local
import com.quangnguyen.stackoverflowclient.data.repository.QuestionDataSource
import com.quangnguyen.stackoverflowclient.data.repository.Remote
import com.quangnguyen.stackoverflowclient.data.repository.local.QuestionLocalDataSource
import com.quangnguyen.stackoverflowclient.data.repository.remote.QuestionRemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class QuestionRepositoryModule {

    @Provides
    @Local
    @Singleton
    fun provideLocalDataSource(questionLocalDataSource: QuestionLocalDataSource): QuestionDataSource {
        return questionLocalDataSource
    }

    @Provides
    @Remote
    @Singleton
    fun provideRemoteDataSource(questionRemoteDataSource: QuestionRemoteDataSource): QuestionDataSource {
        return questionRemoteDataSource
    }

}
