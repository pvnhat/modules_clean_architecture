package com.example.clear_architecture_base.ui.binding

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.RequestOptions.circleCropTransform
import com.example.clear_architecture_base.utils.extensions.gone
import com.example.clear_architecture_base.utils.extensions.visible
import com.example.clear_architecture_base.utils.image.GlideApp

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("isVisible")
    fun isVisible(view: View, condition: Boolean) {
        if (condition) view.visible() else view.gone()
    }

    @SuppressLint("CheckResult")
    @JvmStatic
    @BindingAdapter(
        value = ["loadUrl", "uri", "placeholder", "isCircle", "isCenterCrop", "radiusValue"],
        requireAll = false
    )
    fun loadUrl(
        imageView: ImageView,
        url: String?,
        uri: Uri?,
        placeholder: Drawable? = null,
        isCircle: Boolean = false,
        isCenterCrop: Boolean = false,
        radiusValue: Float? = null,
    ) {
        val requestBuilder =
            if (uri != null) {
                GlideApp.with(imageView.context).load(uri)
            } else {
                GlideApp.with(imageView.context).load(url)
            }

        requestBuilder.apply(RequestOptions().placeholder(placeholder)).apply {
            if (isCircle) {
                apply(circleCropTransform())
            }
            if (isCenterCrop) {
                apply(
                    RequestOptions().transform(
                        CenterCrop(),
                        RoundedCorners(radiusValue?.toInt() ?: 1)
                    )
                )
            }
        }.into(imageView)
    }
}
