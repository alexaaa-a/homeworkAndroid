package com.first.homework

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.show(text: String) = Snackbar.make(this, text, Snackbar.LENGTH_LONG).show()