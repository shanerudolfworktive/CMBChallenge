package com.shanerudolf.cbmcodechalllenge.views.customViews

import android.os.Handler
import android.os.Looper
import android.widget.TextView
import com.mindorks.placeholderview.annotations.Layout
import com.mindorks.placeholderview.annotations.Resolve
import com.mindorks.placeholderview.annotations.View
import com.mindorks.placeholderview.annotations.swipe.*
import com.shanerudolf.cbmcodechalllenge.R
import io.reactivex.subjects.PublishSubject

/**
 * Created by shane1 on 2/8/18.
 */
@Layout(R.layout.view_swipe_card)
class SwipeCardView {
    @View(R.id.bioTextView)
    private val bioTextView: TextView? = null

    @View(R.id.nameTextView)
    private val nameTextView: TextView? = null

    @View(R.id.titleTextView)
    private val titleTextView: TextView? = null

    val swipeLeft: PublishSubject<SwipeCardView> = PublishSubject.create()
    val swipeRight: PublishSubject<SwipeCardView> = PublishSubject.create()
    val resolve: PublishSubject<SwipeCardView> = PublishSubject.create()

    @Resolve
    private fun onResolved() {
        Handler(Looper.getMainLooper()).post({
            resolve.onNext(this)
        })
    }

    fun setBio(bio: String) {
        bioTextView!!.text = bio
    }

    fun setName(name: String) {
        nameTextView!!.setText(name)
    }

    fun setTitle(title: String) {
        titleTextView!!.text = title
    }

    @SwipeOut
    private fun onSwipedLeft() {
        swipeLeft.onNext(this)
    }

    @SwipeIn
    private fun onSwipedRight() {
        swipeRight.onNext(this)
    }
}