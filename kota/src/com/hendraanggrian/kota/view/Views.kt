@file:JvmName("Views")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package com.hendraanggrian.kota.view

import android.view.View
import com.hendraanggrian.kota.annotation.Visibility

/**
 * Sets visibility boolean to View and perform block if View is visible.
 */
@JvmOverloads inline fun <V : View> V.setVisibleBy(
        visible: Boolean,
        noinline doIfVisible: (V.() -> Unit)? = null,
        noinline doIfNotVisible: (V.() -> Unit)? = null
): Unit = setVisibilityBy(if (visible) View.VISIBLE else View.GONE, doIfVisible, doIfNotVisible)

/**
 * Sets visibility int to View and perform block if View is visible.
 */
@JvmOverloads inline fun <V : View> V.setVisibilityBy(
        @Visibility visibility: Int,
        noinline doIfVisible: (V.() -> Unit)? = null,
        noinline doIfNotVisible: (V.() -> Unit)? = null
): Unit {
    if (this.visibility != visibility) {
        this.visibility = visibility
    }
    when (visibility) {
        View.VISIBLE -> doIfVisible?.invoke(this)
        else -> doIfNotVisible?.invoke(this)
    }
}