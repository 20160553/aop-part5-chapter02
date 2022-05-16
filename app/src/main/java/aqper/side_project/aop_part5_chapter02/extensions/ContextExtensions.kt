package aqper.side_project.aop_part5_chapter02.extensions

import android.content.Context
import android.widget.Toast

internal fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}