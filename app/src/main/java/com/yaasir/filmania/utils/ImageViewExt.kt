package com.yaasir.filmania.utils

import android.widget.ImageView
import androidx.core.content.ContextCompat
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
    val circularProgressDrawable = CircularProgressDrawable(context).apply {
        strokeWidth = 5f
        centerRadius= 30f
        setColorSchemeColors(ContextCompat.getColor(context, R.color.blue_500))
    }
    circularProgressDrawable.start()
    Glide.with(this).load(Configs.MOVIES_IMG_URL + url).placeholder(circularProgressDrawable)
        .centerCrop().into(this)
}