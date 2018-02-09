package com.shanerudolf.cbmcodechalllenge.views

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shanerudolf.cbmcodechalllenge.BaseDialogFragment
import com.shanerudolf.cbmcodechalllenge.R
import com.shanerudolf.cbmcodechalllenge.databinding.FragmentPhotoBinding
import com.shanerudolf.cbmcodechalllenge.viewmodels.PhotoViewModel

/**
 * Created by shane1 on 2/8/18.
 */
class PhotoFragment : BaseDialogFragment(){
    var photoUrl: String ? = null

    private var fragmentPhotoBinding : FragmentPhotoBinding? = null

    companion object {
        fun newInstance(photoUrl: String): PhotoFragment {
            val fragment = PhotoFragment()
            fragment.photoUrl = photoUrl
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentPhotoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_photo, container, false)
        val rootView = fragmentPhotoBinding!!.root
        fragmentPhotoBinding!!.photoViewModel = PhotoViewModel(photoUrl!!)
        return rootView
    }
}