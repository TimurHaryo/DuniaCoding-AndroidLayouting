package id.duniacoding.layouting.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadImage")
fun ImageView.loadImage(image: Any) {
    try {
        Glide.with(this)
            .load(image)
            .into(this)
    } catch (t: Throwable){
        throw Throwable()
    }
}