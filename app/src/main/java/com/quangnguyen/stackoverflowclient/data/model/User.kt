package com.quangnguyen.stackoverflowclient.data.model

import com.google.gson.annotations.SerializedName

class User {
    @SerializedName("user_id")
    var id: Long = 0

    @SerializedName("display_name")
    var name: String? = null

    @SerializedName("profile_image")
    var image: String? = null

    @SerializedName("link")
    var link: String? = null
}
