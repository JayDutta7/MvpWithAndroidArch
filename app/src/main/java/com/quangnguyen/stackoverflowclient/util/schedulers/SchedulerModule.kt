package com.quangnguyen.stackoverflowclient.util.schedulers

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import com.quangnguyen.stackoverflowclient.util.schedulers.SchedulerType.IO
import com.quangnguyen.stackoverflowclient.util.schedulers.SchedulerType.UI

/**
 * Provides common Schedulers used by RxJava
 */
@Module
class SchedulerModule {

    @Provides
    @RunOn(IO)
     fun provideIo(): Scheduler {
        return Schedulers.io()
    }

    @Provides
    @RunOn(UI)
     fun provideUi(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}
