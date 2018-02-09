package com.shanerudolf.cbmcodechalllenge

import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.shanerudolf.cbmcodechalllenge.views.LandingFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setStartupFragment(LandingFragment.newInstance())
    }

    fun setStartupFragment(fragment: Fragment){
        fragmentManager.beginTransaction().replace(R.id.fragmentHolder, fragment).commit()
    }
}
