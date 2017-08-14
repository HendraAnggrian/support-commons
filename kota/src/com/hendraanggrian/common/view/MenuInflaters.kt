@file:JvmName("MenuInflaters")
@file:Suppress("NOTHING_TO_INLINE")

package com.hendraanggrian.common.view

import android.app.Activity
import android.support.annotation.MenuRes
import android.view.Menu

inline fun Activity.inflateMenu(
        @MenuRes menuRes: Int,
        menu: Menu
): Menu {
    menuInflater.inflate(menuRes, menu)
    return menu
}