package com.mvvm.dogs.data.data_source.response.pojo

import com.squareup.moshi.Json

data class Dogs(
    @field:Json(name = "doges") val urls: List<String>
)