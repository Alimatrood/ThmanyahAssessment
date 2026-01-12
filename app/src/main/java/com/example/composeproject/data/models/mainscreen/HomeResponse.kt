package com.example.composeproject.data.models.mainscreen

import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("sections")
    val sections: List<Section>
)



