package kr.ac.kumoh.ce.s20200694.s23termproject

import retrofit2.http.GET

interface GameApi {
    @GET("game")
    suspend fun getGames(): List<Game>
}