package com.yaasir.filmania.utils

import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.yaasir.filmania.R

/**
 * [ImageView.loadImage]
 * An extension function load image with [Glide] library
 * this will also add [CircularProgressDrawable] as a placeholder
 * @param url as [String]
 */
fun ImageView.loadImage(url: String?) {
    val circularProgressDrawable = CircularProgressDrawable(context)
    circularProgressDrawable.strokeWidth = 5f
    circularProgressDrawable.centerRadius = 30f
    circularProgressDrawable.setColorSchemeColors(R.color.blue_500)
    circularProgressDrawable.start()
    Glide.with(this).load(Configs.MOVIES_IMG_URL + url).placeholder(circularProgressDrawable)
        .centerCrop().into(this)
}