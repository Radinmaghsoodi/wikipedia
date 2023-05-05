package ir.radindev.Wikipedia.data

data class ItemPost (
     val imgUrl :String ,
     val txtTitle:String,
     val txtSubTitle:String,
     val txtDetail:String,
// for trend fragment=>
     val isTrend:Boolean,
     val insight :String
        )