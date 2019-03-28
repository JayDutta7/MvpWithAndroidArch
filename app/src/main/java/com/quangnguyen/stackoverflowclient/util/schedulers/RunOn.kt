package com.quangnguyen.stackoverflowclient.util.schedulers

import javax.inject.Qualifier
import kotlin.annotation.Retention
import kotlin.annotation.MustBeDocumented

/**
 * Qualifier to define Scheduler type (io, computation, or ui main thread).
 */
@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class RunOn(val value: SchedulerType = SchedulerType.IO)
