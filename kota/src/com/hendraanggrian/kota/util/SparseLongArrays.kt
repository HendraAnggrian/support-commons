@file:JvmName("SparseLongArray")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package com.hendraanggrian.kota.util

import android.annotation.TargetApi
import android.support.annotation.RequiresApi
import android.util.SparseLongArray

@RequiresApi(18)
@TargetApi(18)
inline fun SparseLongArray.hasKey(key: Int) = indexOfKey(key) > -1

@RequiresApi(18)
@TargetApi(18)
inline fun SparseLongArray.hasValue(value: Long) = indexOfValue(value) > -1