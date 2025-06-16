package dora.widget

import android.animation.ValueAnimator
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Shader
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.core.content.ContextCompat
import dora.widget.skeletonview.R

/**
 * A skeleton loading view with shimmer effect.
 *
 * XML attributes (attrs.xml):
 * ```xml
 * <declare-styleable name="DoraSkeletonView">
 *     <attr name="dview_sv_shapeType" format="enum">
 *         <enum name="rectangle" value="0" />
 *         <enum name="circle" value="1" />
 *     </attr>
 *     <attr name="dview_sv_cornerRadius" format="dimension" />
 *     <attr name="dview_sv_primaryColor" format="color" />
 *     <attr name="dview_sv_secondaryColor" format="color" />
 *     <attr name="dview_sv_shimmer" format="boolean" />
 *     <attr name="dview_sv_animDuration" format="integer" />
 * </declare-styleable>
 * ```
 *
 * Usage:
 * ```xml
 * <dora.widget.DoraSkeletonView
 *     android:layout_width="match_parent"
 *     android:layout_height="200dp"
 *     app:dview_sv_shapeType="rectangle"
 *     app:dview_sv_cornerRadius="8dp"
 *     app:dview_sv_primaryColor="@color/skeleton_primary"
 *     app:dview_sv_secondaryColor="@color/skeleton_secondary"
 *     app:dview_sv_shimmer="true"
 *     app:dview_sv_animDuration="1500" />
 * ```
 */
class DoraSkeletonView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var shapeType: ShapeType = ShapeType.RECTANGLE
    private var cornerRadius: Float = 0f
    private var primaryColor: Int = 0
    private var secondaryColor: Int = 0
    private var shimmer: Boolean = true
    private var animDuration: Long = 1500L

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var shimmerAnimator: ValueAnimator? = null
    private var gradient: LinearGradient? = null
    private var translateX = 0f

    init {
        val ta: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.DoraSkeletonView)
        shapeType = ShapeType.values()[ta.getInt(R.styleable.DoraSkeletonView_dview_sv_shapeType, 0)]
        cornerRadius = ta.getDimension(R.styleable.DoraSkeletonView_dview_sv_cornerRadius, 0f)
        primaryColor = ta.getColor(
            R.styleable.DoraSkeletonView_dview_sv_primaryColor,
            ContextCompat.getColor(context, android.R.color.darker_gray)
        )
        secondaryColor = ta.getColor(
            R.styleable.DoraSkeletonView_dview_sv_secondaryColor,
            ContextCompat.getColor(context, android.R.color.white)
        )
        shimmer = ta.getBoolean(R.styleable.DoraSkeletonView_dview_sv_shimmer, true)
        animDuration = ta.getInt(R.styleable.DoraSkeletonView_dview_sv_animDuration, animDuration.toInt()).toLong()
        ta.recycle()
        if (shimmer) setupShimmer()
    }

    private fun setupShimmer() {
        shimmerAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
            duration = animDuration
            repeatCount = ValueAnimator.INFINITE
            interpolator = LinearInterpolator()
            addUpdateListener {
                translateX = it.animatedFraction * width
                invalidate()
            }
            start()
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        gradient = LinearGradient(
            -w.toFloat(), 0f,
            0f, 0f,
            intArrayOf(primaryColor, secondaryColor, primaryColor),
            floatArrayOf(0f, 0.5f, 1f),
            Shader.TileMode.CLAMP
        )
        paint.shader = gradient
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.shader?.setLocalMatrix(android.graphics.Matrix().apply {
            setTranslate(translateX, 0f)
        })

        when (shapeType) {
            ShapeType.RECTANGLE -> {
                val rect = RectF(0f, 0f, width.toFloat(), height.toFloat())
                if (cornerRadius > 0) {
                    canvas.drawRoundRect(rect, cornerRadius, cornerRadius, paint)
                } else {
                    canvas.drawRect(rect, paint)
                }
            }
            ShapeType.CIRCLE -> {
                val radius = width.coerceAtMost(height) / 2f
                canvas.drawCircle(width / 2f, height / 2f, radius, paint)
            }
        }
    }

    enum class ShapeType {
        RECTANGLE,
        CIRCLE
    }

    /**
     * Stop shimmer animation when detached.
     */
    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        shimmerAnimator?.cancel()
    }
}
