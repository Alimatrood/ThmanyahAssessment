package com.example.composeproject.data.models.mainscreen

import com.google.gson.annotations.SerializedName

data class Section(
    @SerializedName("name")
    val name: String,
    
    @SerializedName("type")
    val type: String,
    
    @SerializedName("content_type")
    val contentType: String,


    @SerializedName("content")
    val content: List<Any>
)


