package com.mvvm.dogs.data.data_source

import com.mvvm.dogs.data.data_source.remote.DogsApi
import com.mvvm.dogs.data.data_source.remote.NetworkManager

class GalleryDataSource(val networkManager: NetworkManager) {

    /** it is better  to delegate some logic related to error handling to NetworkManager. In this case it is simplified   */
    fun dogsUrl(count: Int) = networkManager.networkDogsClient().create(DogsApi::class.java).getImgUrls(count)


}
