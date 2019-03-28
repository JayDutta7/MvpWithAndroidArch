package com.quangnguyen.stackoverflowclient.data.api

import com.google.gson.annotations.SerializedName
import com.quangnguyen.stackoverflowclient.data.model.Question

class QuestionResponse {
    @SerializedName("items")
    var questions: List<Question>? = null
}
