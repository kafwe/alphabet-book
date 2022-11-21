package com.example.alphabetbook

import android.content.Context
import android.graphics.Bitmap
import com.bumptech.glide.Glide

/**
 * Factory that downsamples and returns bitmaps of images.
 *
 * @author Jordy Kafwe
 */
class ImageFactory {
    companion object {
        private const val height = 369
        private const val width = 426

        /**
         * Creates a downsampled bitmap of a given image
         *
         * @param imageName the name of the image to create a bitmap of
         * @param context the context (from AppCompactActivity) to use to retrieve the image
         */
        fun createBitmap(imageName: String, context: Context): Bitmap {
                val image = context.resources
                    .getIdentifier(imageName, "drawable", context.packageName)

                val futureTarget = Glide.with(context)
                    .asBitmap()
                    .load(image)
                    .submit(width, height) // downsamples images according to given width and height

                return futureTarget.get()
        }
    }
}