package com.yaasir.filmania.utils

import android.content.res.ColorStateList
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.yaasir.filmania.R

fun ImageView.loadImage(url: String?) {
    val circularProgressDrawable = CircularProgressDrawable(context)
    circularProgressDrawable.strokeWidth = 5f
    circularProgressDrawable.centerRadius = 30f
    circularProgressDrawable.setColorSchemeColors(R.color.blue_500)
    circularProgressDrawable.start()
    Glide.with(this).load(API.MOVIES_IMG_URL + url).placeholder(circularProgressDrawable).centerCrop().into(this)
}