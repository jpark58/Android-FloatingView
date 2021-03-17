package com.example.floatingview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import androidx.constraintlayout.widget.ConstraintLayout

class FloatingView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0):
    ConstraintLayout(context, attrs, defStyleAttr) {
    private var moveX = 0f
    private var moveY = 0f

    init{
        val a = context.theme.obtainStyledAttributes(attrs, R.styleable.FloatingView, defStyleAttr, 0)
        LayoutInflater.from(context).inflate(a.getResourceId(R.styleable.FloatingView_setLayout, 0), this, true)
        a.recycle()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                moveX = this.x - event.rawX
                moveY = this.y - event.rawY
            }
            MotionEvent.ACTION_MOVE -> {
                this.animate().x(event.rawX + moveX).y(event.rawY + moveY).setDuration(0).start()
            }

        }
        return true
    }

    fun setLayout(id: Int):Int{
        return id
    }

}