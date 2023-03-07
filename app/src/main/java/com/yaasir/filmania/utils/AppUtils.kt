package com.yaasir.filmania.utils

import android.view.View
import com.google.android.material.snackbar.Snackbar

/**
 * [showSnackBar]
 * a function to show snack bar anywhere in the application
 * @param view [View]
 * @param message [String]
 */
fun showSnackBar(view: View, message: String) {
    Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
}