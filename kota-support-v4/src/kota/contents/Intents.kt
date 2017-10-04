@file:JvmName("SupportIntentsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kota.contents

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment

/** Starts an activity that can handle this [intent], otherwise [fallback] will be executed. */
inline fun Fragment.startActivityResolved(intent: Intent, fallback: () -> Unit) =
        if (intent.isResolvable(context)) startActivity(intent)
        else fallback()

/** Starts an activity that can handle this [intent] with options, otherwise [fallback] will be executed. */
inline fun Fragment.startActivityResolved(intent: Intent, options: Bundle, fallback: () -> Unit) =
        if (intent.isResolvable(context)) startActivity(intent, options)
        else fallback()

/** Starts an activity for result that can handle this [intent], otherwise [fallback] will be executed. */
inline fun Fragment.startActivityForResultResolved(intent: Intent, requestCode: Int, fallback: () -> Unit) =
        if (intent.isResolvable(context)) startActivityForResult(intent, requestCode)
        else fallback()

/** Starts an activity for result that can handle this [intent] with options, otherwise [fallback] will be executed. */
inline fun Fragment.startActivityForResultResolved(intent: Intent, requestCode: Int, options: Bundle, fallback: () -> Unit) =
        if (intent.isResolvable(context)) startActivityForResult(intent, requestCode, options)
        else fallback()