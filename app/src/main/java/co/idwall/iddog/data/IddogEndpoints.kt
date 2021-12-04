package co.idwall.iddog.data

import co.idwall.iddog.domain.DogFeed
import co.idwall.iddog.domain.LoginBody
import co.idwall.iddog.domain.LoginResponse
import retrofit2.http.*

interface IddogEndpoints {

    @POST("signup")
    suspend fun login(
        @Body loginBody: LoginBody
    ): LoginResponse

    @GET("feed/")
    suspend fun getFeed(
        @Header("Authorization") token: String,
        @Query("category")raca: String
    ): DogFeed
}