package com.quangnguyen.stackoverflowclient.data

import androidx.room.Room
import android.content.Context
import com.quangnguyen.stackoverflowclient.data.database.QuestionDao
import com.quangnguyen.stackoverflowclient.data.database.StackOverflowDb
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Named(DATABASE)
    internal fun provideDatabaseName(): String {
        return Config.DATABASE_NAME
    }

    @Provides
    @Singleton
    internal fun provideStackOverflowDao(context: Context, @Named(DATABASE) databaseName: String): StackOverflowDb {
        return Room.databaseBuilder(context, StackOverflowDb::class.java, databaseName).build()
    }

    @Provides
    @Singleton
    internal fun provideQuestionDao(stackOverflowDb: StackOverflowDb): QuestionDao {
        return stackOverflowDb.questionDao()
    }

    companion object {
        private const val DATABASE = "database_name"
    }
}
