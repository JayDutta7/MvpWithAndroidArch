package com.quangnguyen.stackoverflowclient.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.quangnguyen.stackoverflowclient.data.model.Question

@Database(entities = [Question::class], version = 1)
abstract class StackOverflowDb : RoomDatabase() {

    abstract fun questionDao(): QuestionDao
}
