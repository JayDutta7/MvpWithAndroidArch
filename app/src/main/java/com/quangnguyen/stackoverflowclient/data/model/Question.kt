package com.quangnguyen.stackoverflowclient.data.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.quangnguyen.stackoverflowclient.data.Config

@Entity(tableName = Config.QUESTION_TABLE_NAME)
class Question {

    @SerializedName("question_id")
    @PrimaryKey
    var id: Long = 0

    @SerializedName("owner")
    @Embedded(prefix = "owner_")
    var user: User? = null

    @SerializedName("creation_date")
    @ColumnInfo(name = "creation_date")
    var creationDate: Long = 0

    @SerializedName("title")
    var title: String? = null

    @SerializedName("link")
    var link: String? = null
}
