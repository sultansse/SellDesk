package com.software1t.selldesk.data.model

//@Parcelize
data class CarDataModel(
    val id: Int,
    val name: String,
    val price: Int,
    val image: Int,
    val description: String,
    val city: String,
    val isLiked: Boolean,
    val postDate: String,
    val postViewedCount: Long,
    val postLikedCount: Long,
)
/*  : Parcelable, Mappable<CarDomainModel> {

  val DATE_FORMAT = "yyyy-MM-dd"
  @SuppressLint("SimpleDateFormat")
  val formatter = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())


  override fun map() = CarDomainModel(
      id = id,
      name = name,
      price = "$price $tenge",
      image = image,
      description = description,
      city = city,
      isLiked = isLiked,
      postDate = formatter.parse(postDate) ?: formatter.parse("2000-01-01"),
      postViewedCount = postViewedCount,
      postLikedCount = postLikedCount,
  )
}*/