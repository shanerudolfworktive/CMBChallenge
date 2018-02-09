package com.shanerudolf.cbmcodechalllenge.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shanerudolf.cbmcodechalllenge.BaseFragment
import com.shanerudolf.cbmcodechalllenge.R
import kotlinx.android.synthetic.main.fragment_landing.*

/**
 * Created by shane1 on 2/8/18.
 */
class LandingFragment : BaseFragment(){
    companion object {
        fun newInstance(): LandingFragment  {
            return LandingFragment ()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_landing, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startButton.setOnClickListener{
            fragmentManager.beginTransaction().replace(id, DiscoveryFragment.newInstance()).commit()
        }
    }
}