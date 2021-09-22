package com.example.geotask.presentation.selectionWaypoints

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import androidx.appcompat.widget.AppCompatAutoCompleteTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class LimitVisibleItemLinearLayoutManager(context: Context?, orientation: Int, reverseLayout: Boolean, val itemsPerPage: Int) : LinearLayoutManager(context, orientation, reverseLayout) {

    override fun checkLayoutParams(lp: RecyclerView.LayoutParams): Boolean {
        return super.checkLayoutParams(lp) && lp.height == itemSize
    }

    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
        return setProperItemSize(super.generateDefaultLayoutParams())
    }

    override fun generateLayoutParams(lp: ViewGroup.LayoutParams): RecyclerView.LayoutParams {
        return setProperItemSize(super.generateLayoutParams(lp))
    }

    private fun setProperItemSize(lp: RecyclerView.LayoutParams): RecyclerView.LayoutParams {
        val itemSize = itemSize
        if (orientation == VERTICAL) {
            lp.height = itemSize
        } else {
            lp.width = itemSize
        }
        return lp
    }

    private val itemSize: Int
        private get() {
            val pageSize = if (orientation == VERTICAL) height else width
            return Math.round(pageSize.toFloat() / itemsPerPage)
        }

}

