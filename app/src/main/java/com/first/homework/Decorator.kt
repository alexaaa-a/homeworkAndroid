package com.first.homework

import android.content.Context
import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class Decorator(context: Context, space: Float) : RecyclerView.ItemDecoration() {
    private val spacePX: Int = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, space, context.resources.displayMetrics
    ).toInt()

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        val itemCount = state.itemCount

        outRect.left = spacePX
        outRect.right = spacePX
        outRect.bottom = spacePX

        if (position == 0) {
            outRect.top = spacePX
        } else {
            outRect.top = 0
        }
    }
}
