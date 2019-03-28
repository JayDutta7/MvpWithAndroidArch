package com.quangnguyen.stackoverflowclient.ui.base

import androidx.lifecycle.LifecycleRegistry
import androidx.appcompat.app.AppCompatActivity
import com.quangnguyen.stackoverflowclient.AndroidApplication
import com.quangnguyen.stackoverflowclient.data.QuestionRepositoryComponent

open class BaseActivity : AppCompatActivity() {
    private val lifecycleRegistry = LifecycleRegistry(this)

    protected val questionRepositoryComponent: QuestionRepositoryComponent?
        get() = (application as AndroidApplication).questionRepositoryComponent

    override fun getLifecycle(): LifecycleRegistry {
        return lifecycleRegistry
    }
}
