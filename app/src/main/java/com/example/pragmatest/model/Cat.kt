package com.example.pragmatest.model

import com.google.gson.annotations.SerializedName

class Cat(
    @SerializedName("name") val breedName: String? = null,
    @SerializedName("origin") val origin: String? = null,
    @SerializedName("affection_level") val affectionLevel: Int? = null,
    @SerializedName("intelligence") val intelligence: Int? = null,
    val imageUrl: String? = null
)
