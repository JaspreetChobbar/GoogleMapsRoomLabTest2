package yoyo.jassie.labtest2.model

import android.content.Context
import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import yoyo.jassie.labtest2.util.ImageUtils


@Entity
data class Bookmark(
    @PrimaryKey(autoGenerate = true) var id: Long? = null,
    var title: String = "",
    var subTitle: String = "",
    var latitude: Double = 0.0,
    var longitude: Double = 0.0
) {

  fun setImage(image: Bitmap, context: Context) {
    id?.let {
      ImageUtils.saveBitmapToFile(context, image,
          generateImageFilename(it))
    }
  }
  companion object {
    fun generateImageFilename(id: Long): String {
      return "bookmark$id.png"
    }
  }
}
