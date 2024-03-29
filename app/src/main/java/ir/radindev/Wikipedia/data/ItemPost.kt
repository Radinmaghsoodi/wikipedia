package ir.radindev.Wikipedia.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Suppress("DEPRECATED_ANNOTATION")
@Parcelize
data class ItemPost (
     val imgUrl :String ,
     val txtTitle:String,
     val txtSubTitle:String,
     val txtDetail:String,
// for trend fragment=>
     val isTrend:Boolean,
     val insight :String
        ): Parcelable