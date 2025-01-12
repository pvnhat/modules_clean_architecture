package com.example.clear_architecture_base.utils.extensions

import android.os.SystemClock
import android.view.View
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.core.view.isGone
import androidx.core.view.isVisible

fun View.safeClick(blockInMillis: Long = 1000L, onClick: (View) -> Unit) {
    var lastClickTime: Long = 0
    setOnClickListener {
        if (SystemClock.elapsedRealtime() - lastClickTime < blockInMillis) return@setOnClickListener
        lastClickTime = SystemClock.elapsedRealtime()
        onClick(this)
    }
}

fun View.visible() {
    if (!isVisible) visibility = View.VISIBLE
}

fun View.gone() {
    if (!isGone) visibility = View.GONE
}

fun goneViews(vararg views: View) {
    views.forEach { it.gone() }
}

fun TextView.setTopIcon(@DrawableRes icon: Int) {
    setCompoundDrawablesWithIntrinsicBounds(0, icon, 0, 0)
}
