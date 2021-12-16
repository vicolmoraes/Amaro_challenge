package co.idwall.iddog.data


import co.idwall.iddog.domain.GuideShop
import retrofit2.http.*

interface AmaroEndpoints {
    @GET("guideShops.json")
    suspend fun getShop(): List<GuideShop>
}
