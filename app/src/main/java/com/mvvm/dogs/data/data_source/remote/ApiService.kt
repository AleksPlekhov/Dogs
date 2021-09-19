package com.mvvm.dogs.data.data_source.remote

import com.mvvm.dogs.data.data_source.response.pojo.Dogs
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DogsApi {
    @GET("/bomb")
    fun getImgUrls(@Query("count") count: Int): Single<Response<Dogs>>


}