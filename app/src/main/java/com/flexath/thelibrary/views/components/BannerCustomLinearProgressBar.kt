package com.flexath.thelibrary.views.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.content.withStyledAttributes
import com.flexath.thelibrary.R

class BannerCustomLinearProgressBar(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private var contextCircular = context

    companion object {
        private const val DEFAULT_PROGRESS = 0
        private const val DEFAULT_PROGRESS_MAX = 0
    }

    private var trackColor = contextCircular?.let { ContextCompat.getColor(it, R.color.white) } ?: 0
    private var indicatorColor = contextCircular?.let { ContextCompat.getColor(it,R.color.colorSecondary) } ?: 0
    private var progress = DEFAULT_PROGRESS
    private var progressMax = DEFAULT_PROGRESS_MAX

    private val paintForIndicatorColor = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = indicatorColor
        style = Paint.Style.FILL
        strokeWidth = 14f
    }

    private val paintForTrackColor = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = trackColor
        style = Paint.Style.FILL
        strokeWidth = 14f
    }

    private val paintForPercentText = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textAlign = Paint.Align.CENTER
        textSize = 38.0f
        color = contextCircular?.let { ContextCompat.getColor(it,R.color.colorSecondary) } ?: 0
        typeface = Typeface.create("", Typeface.BOLD)
    }

    init {
        setUpAttributes(attrs)
    }

    private fun setUpAttributes(attrs: AttributeSet?) {
        context.withStyledAttributes(attrs, R.styleable.CustomProgressBar){
            trackColor = getColor(R.styleable.CustomProgressBar_customTrackColor, trackColor)
            indicatorColor = getColor(R.styleable.CustomProgressBar_customIndicatorColor, indicatorColor)
            progress = getInteger(R.styleable.CustomProgressBar_customProgress, DEFAULT_PROGRESS)
            progressMax = getInteger(R.styleable.CustomProgressBar_customProgressMax, DEFAULT_PROGRESS_MAX)
        }
    }

    override fun onDraw(canvas: Canvas?) {

        canvas?.drawLine(0f,0f,width.toFloat(),0f,paintForIndicatorColor)
        canvas?.drawLine(0f,0f, progress.toFloat(),0f,paintForTrackColor)

        super.onDraw(canvas)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val size = measuredWidth.coerceAtMost(measuredHeight)
        setMeasuredDimension(size,size)
    }
}