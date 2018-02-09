package com.shanerudolf.cbmcodechalllenge.views.customViews

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.WindowManager
import com.mindorks.placeholderview.SwipeDecor
import com.mindorks.placeholderview.SwipePlaceHolderView
import com.mindorks.placeholderview.SwipeViewBuilder
import com.shanerudolf.cbmcodechalllenge.R
import com.shanerudolf.cbmcodechalllenge.utils.ViewUtil

/**
 * Created by shane1 on 2/8/18.
 */
class CMBSwipePlaceHolderView : SwipePlaceHolderView {
    constructor (context: Context) : super(context) {
        initialize(context)
    }

    constructor (context: Context, attrs: AttributeSet) : super(context, attrs) {
        initialize(context)
    }

    constructor (context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initialize(context)
    }

    private fun initialize(context: Context) {
        val bottomMargin = ViewUtil.dpToPx(160)
        val windowSize = ViewUtil.getDisplaySize(context.getSystemService(Context.WINDOW_SERVICE) as WindowManager)

        getBuilder<SwipePlaceHolderView, SwipeViewBuilder<SwipePlaceHolderView>>()
                ?.setDisplayViewCount(3)
                ?.setIsUndoEnabled(true)
                ?.setHeightSwipeDistFactor(10f)
                ?.setWidthSwipeDistFactor(5f)
                ?.setSwipeDecor(SwipeDecor()
                        .setViewWidth(windowSize.x)
                        .setViewHeight(windowSize.y - bottomMargin)
                        .setViewGravity(Gravity.TOP)
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setSwipeMaxChangeAngle(2f)
                        .setSwipeInMsgLayoutId(R.layout.view_accept)
                        .setSwipeOutMsgLayoutId(R.layout.view_reject))
    }

}