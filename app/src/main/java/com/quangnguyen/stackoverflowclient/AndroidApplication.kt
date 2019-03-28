package com.quangnguyen.stackoverflowclient

import android.app.Application

import com.facebook.stetho.Stetho
import com.quangnguyen.stackoverflowclient.data.DaggerQuestionRepositoryComponent
import com.quangnguyen.stackoverflowclient.data.QuestionRepositoryComponent
import com.squareup.leakcanary.LeakCanary

import timber.log.Timber



class AndroidApplication : Application() {

    var questionRepositoryComponent: QuestionRepositoryComponent? = null

    override fun onCreate() {
        super.onCreate()

        initializeDependencies()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Stetho.initializeWithDefaults(this)
        }

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        LeakCanary.install(this)
    }

    private fun initializeDependencies() {
        questionRepositoryComponent = DaggerQuestionRepositoryComponent.builder()
                .appModule(AppModule(this))
                .build()
    }


}


