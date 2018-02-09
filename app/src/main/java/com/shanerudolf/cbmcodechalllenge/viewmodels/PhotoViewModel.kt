package com.shanerudolf.cbmcodechalllenge.viewmodels

import android.databinding.BaseObservable

/**
 * Created by shane1 on 2/9/18.
 */
class PhotoViewModel{
    private var photoUrl: String? = null

    constructor(photoUrl : String){
        this.photoUrl = photoUrl
    }

    public fun getPhotoUrl() : String{
        return photoUrl!!
    }
}