package com.quangnguyen.stackoverflowclient.ui.questions

import com.quangnguyen.stackoverflowclient.data.model.Question
import com.quangnguyen.stackoverflowclient.ui.base.BasePresenter

interface QuestionsContract {
    interface View {
        fun showQuestions(questions: List<Question>)

        fun clearQuestions()

        fun showNoDataMessage()

        fun showErrorMessage(error: String)

        fun showQuestionDetail(question: Question)

        fun stopLoadingIndicator()

        fun showEmptySearchResult()
    }

    interface Presenter : BasePresenter<QuestionsContract.View> {
        fun loadQuestions(onlineRequired: Boolean)

        fun getQuestion(questionId: Long)

        fun search(questionTitle: String)
    }
}
