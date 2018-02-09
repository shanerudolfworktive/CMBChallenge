package com.shanerudolf.cbmcodechalllenge.views.customViews

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView

/**
 * Created by shane1 on 2/8/18.
 */
class SquareImageView : ImageView {
    constructor (context: Context) : super(context)
    constructor (context: Context, attrs: AttributeSet): super(context, attrs)
    constructor (context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr)
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = Math.min(measuredWidth, measuredHeight)
        setMeasuredDimension(width, width)
    }
}