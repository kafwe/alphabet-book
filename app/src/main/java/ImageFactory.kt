import android.content.Context
import android.graphics.Bitmap
import com.bumptech.glide.Glide


class ImageFactory {
    private val height = 623
    private val width = 379

    fun createBitmap(imageName: String, context: Context): Bitmap {
        val image = context.resources
            .getIdentifier(imageName, "drawable", context.packageName)

        val futureTarget = Glide.with(context)
            .asBitmap()
            .load(image)
            .submit(width, height)

        return futureTarget.get()
    }
}