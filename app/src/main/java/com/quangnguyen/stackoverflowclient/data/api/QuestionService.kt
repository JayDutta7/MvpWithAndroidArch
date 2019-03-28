package com.quangnguyen.stackoverflowclient.data.api

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface QuestionService {
    @GET("questions?site=stackoverflow")
    fun loadQuestionsByTag(@Query("tagged") tag: String): Flowable<QuestionResponse>
}
