package com.quangnguyen.stackoverflowclient.ui.questions

import com.quangnguyen.stackoverflowclient.data.QuestionRepositoryComponent
import com.quangnguyen.stackoverflowclient.ui.base.ActivityScope
import com.quangnguyen.stackoverflowclient.util.schedulers.SchedulerModule
import dagger.Component

@ActivityScope
@Component(modules = [QuestionsPresenterModule::class, SchedulerModule::class], dependencies = [QuestionRepositoryComponent::class])
interface QuestionsComponent {
    fun inject(questionsActivity: QuestionsActivity)
}