package com.flexath.thelibrary.views.components

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.core.content.withStyledAttributes
import com.flexath.thelibrary.R

class RoundedProfileImage @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    private var contextCircular = context

    private var cornerRadius = 0f
    private var isActive = false
    private val path = Path()

    private val DEFAULT_ACTIVE_CIRCLE_COLOR = ContextCompat.getColor(contextCircular, R.color.colorAccent)
    private val OUTER_FIRST_CIRCLE_COLOR = ContextCompat.getColor(contextCircular, R.color.colorProfileImageFirst)
    private val OUTER_SECOND_CIRCLE_COLOR = ContextCompat.getColor(contextCircular, R.color.colorProfileImageSecond)
    private val OUTER_THIRD_CIRCLE_COLOR = ContextCompat.getColor(contextCircular, R.color.colorProfileImageThird)
    private val OUTER_FOURTH_CIRCLE_COLOR = ContextCompat.getColor(contextCircular, R.color.colorProfileImageFourth)

    private val paintForBorder = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = DEFAULT_BORDER_COLOR
        style = Paint.Style.STROKE
        strokeWidth = DEFAULT_BORDER_WIDTH
    }

    private val paintFirstForOuterBorder = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = OUTER_FIRST_CIRCLE_COLOR
        style = Paint.Style.STROKE
        strokeWidth = DEFAULT_BORDER_WIDTH
    }

    private val paintSecondForOuterBorder = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = OUTER_SECOND_CIRCLE_COLOR
        style = Paint.Style.STROKE
        strokeWidth = DEFAULT_BORDER_WIDTH
    }

    private val paintThirdForOuterBorder = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = OUTER_THIRD_CIRCLE_COLOR
        style = Paint.Style.STROKE
        strokeWidth = DEFAULT_BORDER_WIDTH
    }

    private val paintFourthForOuterBorder = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = OUTER_FOURTH_CIRCLE_COLOR
        style = Paint.Style.STROKE
        strokeWidth = DEFAULT_BORDER_WIDTH
    }

    companion object {
        private const val DEFAULT_BORDER_WIDTH = 12.0f
        private const val DEFAULT_BORDER_COLOR = Color.WHITE
    }

    init {
        context.withStyledAttributes(attrs, R.styleable.RoundedProfileImage) {
            cornerRadius = getDimension(R.styleable.RoundedProfileImage_cornerRadius, 0f)
            isActive = getBoolean(R.styleable.RoundedProfileImage_isActive, false)
        }

        translationZ = 8f
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        val rectangle = RectF(0f, 0f, width.toFloat(), height.toFloat())
        path.addRoundRect(rectangle, cornerRadius, cornerRadius, Path.Direction.CCW)
        canvas?.clipPath(path)
        super.onDraw(canvas)

        onDrawBorderCircle(canvas)
        onDrawOuterBorderCircle(canvas)

        if (isActive) {
            onDrawActiveCircle(canvas)
        }
    }

    private fun onDrawBorderCircle(canvas: Canvas?) {
        canvas?.drawCircle(
            width / 2f,
            height / 2f,
            cornerRadius - DEFAULT_BORDER_WIDTH / 2f,
            paintForBorder
        )
    }

    private fun onDrawOuterBorderCircle(canvas: Canvas?) {
        val centerX = width / 2f
        val centerY = height / 2f
        val radius = width / 2f

        val rectF = RectF(centerX - radius, centerY - radius, centerX + radius, centerY + radius)

        canvas?.drawArc(rectF, -90f, 90F, false, paintFirstForOuterBorder)
        canvas?.drawArc(rectF, 0f, 90F, false, paintSecondForOuterBorder)
        canvas?.drawArc(rectF, 90f, 90F, false, paintThirdForOuterBorder)
        canvas?.drawArc(rectF, 180f, 90F, false, paintFourthForOuterBorder)

    }

    private fun onDrawActiveCircle(canvas: Canvas?) {

        // For Active Circle
        val paintForActiveCircle = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.FILL
            color = DEFAULT_ACTIVE_CIRCLE_COLOR
            translationZ = 8f
            bringToFront()
        }
        canvas?.drawCircle(
            width.toFloat() * 0.73f,
            height.toFloat() * 0.9f,
            cornerRadius / 8,
            paintForActiveCircle
        )

        // For Active Circle Border
        canvas?.drawCircle(
            width.toFloat() * 0.73f,
            height.toFloat() * 0.9f,
            (cornerRadius / 8) + DEFAULT_BORDER_WIDTH / 2f,
            paintForBorder
        )
    }
}