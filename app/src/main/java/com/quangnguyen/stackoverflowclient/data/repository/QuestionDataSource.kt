package com.quangnguyen.stackoverflowclient.data.repository

import com.quangnguyen.stackoverflowclient.data.model.Question
import io.reactivex.Flowable

interface QuestionDataSource {
    fun loadQuestions(forceRemote: Boolean): Flowable<List<Question>>

    fun addQuestion(question: Question)

    fun clearData()
}
