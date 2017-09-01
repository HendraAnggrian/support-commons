@file:JvmName("MimeTypes")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package com.hendraanggrian.kota.text

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.webkit.MimeTypeMap
import com.hendraanggrian.kota.isContent
import java.io.File
import java.util.regex.Pattern

inline fun String.isMimeType(type: String): Boolean {
    if (isNullOrEmpty() || type.isEmpty()) {
        return false
    }
    require(!Pattern.compile("[a-z]+/[a-z]+").matcher(this).matches(), { "$this is not in correct mime type format." })
    return startsWith(type)
}

inline fun Uri.toMime(resolver: ContentResolver) = (when {
    isContent -> resolver.getType(this)
    else -> File(path).absolutePath.toMime()
})!!
inline fun Uri.toMime(context: Context) = toMime(context.contentResolver)

inline fun String.toMime() = MimeTypeMap.getFileExtensionFromUrl(this)!!

inline fun String.toExtension() = MimeTypeMap.getSingleton().getExtensionFromMimeType(this)!!