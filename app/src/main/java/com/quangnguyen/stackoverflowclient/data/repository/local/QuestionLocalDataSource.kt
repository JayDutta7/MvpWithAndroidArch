package com.quangnguyen.stackoverflowclient.data.repository.local

import com.quangnguyen.stackoverflowclient.data.database.QuestionDao
import com.quangnguyen.stackoverflowclient.data.model.Question
import com.quangnguyen.stackoverflowclient.data.repository.QuestionDataSource
import io.reactivex.Flowable
import javax.inject.Inject

class QuestionLocalDataSource @Inject
constructor(private val questionDao: QuestionDao) : QuestionDataSource {

    override fun loadQuestions(forceRemote: Boolean): Flowable<List<Question>> {
        return questionDao.allQuestions
    }

    override fun addQuestion(question: Question) {
        // Insert new one
        questionDao.insert(question)
    }

    override fun clearData() {
        // Clear old data
        questionDao.deleteAll()
    }
}
