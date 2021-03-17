package com.example.floatingview

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import androidx.constraintlayout.solver.state.Reference
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet


class FloatingMemo @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0):
    ConstraintLayout(context, attrs, defStyleAttr) {
    private var moveX = 0f
    private var moveY = 0f

    init{
        val a = context.theme.obtainStyledAttributes(attrs, R.styleable.FloatingMemo, defStyleAttr, 0)
        LayoutInflater.from(context).inflate(a.getResourceId(R.styleable.FloatingMemo_setLayout, 0), this, true)
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