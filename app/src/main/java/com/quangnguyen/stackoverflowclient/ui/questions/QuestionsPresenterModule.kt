package com.quangnguyen.stackoverflowclient.ui.questions

import dagger.Module
import dagger.Provides

@Module
class QuestionsPresenterModule(private val view: QuestionsContract.View) {

    @Provides
    fun provideView(): QuestionsContract.View {
        return view
    }
}
