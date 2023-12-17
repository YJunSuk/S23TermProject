package kr.ac.kumoh.ce.s20200694.s23termproject

data class Game(
   val id: Int,
   val title: String,
   val release_date: String,
   val genre: String,
   val platform: String?,
   val image_url: String,
)
