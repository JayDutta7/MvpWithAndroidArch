package com.quangnguyen.stackoverflowclient.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.quangnguyen.stackoverflowclient.data.Config
import com.quangnguyen.stackoverflowclient.data.model.Question
import io.reactivex.Flowable

@Dao
interface QuestionDao {
    @get:Query("SELECT * FROM " + Config.QUESTION_TABLE_NAME)
    val allQuestions: Flowable<List<Question>>

    @Query("SELECT * FROM " + Config.QUESTION_TABLE_NAME + " WHERE id == :id")
    fun getQuestionById(id: Int): Flowable<Question>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(question: Question)

    @Query("DELETE FROM " + Config.QUESTION_TABLE_NAME)
    fun deleteAll()
}
