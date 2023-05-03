package com.flexath.thelibrary.views.components

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RoundRectShape
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.content.withStyledAttributes
import com.flexath.thelibrary.R

class RatingCustomLinearProgressBar(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private var contextLinear = context

    companion object {
        private const val DEFAULT_PROGRESS = 0
        private const val DEFAULT_PROGRESS_MAX = 0
        private const val DEFAULT_CORNER_RADIUS = 0f
    }

    private var trackColor = contextLinear?.let { ContextCompat.getColor(it, R.color.colorAccent) } ?: 0
    private var indicatorColor = contextLinear?.let { ContextCompat.getColor(it,R.color.colorPrimaryLight) } ?: 0
    private var progress = DEFAULT_PROGRESS
    private var progressMax = DEFAULT_PROGRESS_MAX
    private var cornerRadius = DEFAULT_CORNER_RADIUS

    private val paintForIndicatorColor = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = indicatorColor
        style = Paint.Style.FILL
        strokeWidth = 50f
    }

    private val paintForTrackColor = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = trackColor
        style = Paint.Style.FILL
        strokeWidth = 50f
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
            cornerRadius = getDimension(R.styleable.CustomProgressBar_customCornerRadius, 0f)
        }
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        val path = Path()
        val rectangle = RectF(0f, 0f, width.toFloat(), height.toFloat())
        path.addRoundRect(rectangle, cornerRadius, cornerRadius, Path.Direction.CW)
        canvas?.clipPath(path)

        canvas?.drawLine(0f,0f,width.toFloat(),0f,paintForIndicatorColor)
        canvas?.drawLine(0f,0f, progress.toFloat(),0f,paintForTrackColor)

        super.onDraw(canvas)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val size = measuredWidth.coerceAtMost(measuredHeight)
        setMeasuredDimension(measuredWidth,50)
    }
}