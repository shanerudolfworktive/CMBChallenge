package com.shanerudolf.cbmcodechalllenge.views

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shanerudolf.cbmcodechalllenge.BaseFragment
import com.shanerudolf.cbmcodechalllenge.R
import com.shanerudolf.cbmcodechalllenge.databinding.FragmentDiscoveryBinding
import com.shanerudolf.cbmcodechalllenge.viewmodels.DiscoveryViewModel
import kotlinx.android.synthetic.main.fragment_discovery.*

/**
 * Created by shane1 on 2/8/18.
 */
class DiscoveryFragment : BaseFragment(){
    companion object {
        fun newInstance(): DiscoveryFragment {
            return DiscoveryFragment()
        }
    }

    private var fragmentDiscoveryBinding : FragmentDiscoveryBinding? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentDiscoveryBinding  = DataBindingUtil.inflate(inflater, R.layout.fragment_discovery, container, false)
        return fragmentDiscoveryBinding!!.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentDiscoveryBinding!!.discoveryViewModel = DiscoveryViewModel(activity = activity, swipeView = swipeView)
    }
}