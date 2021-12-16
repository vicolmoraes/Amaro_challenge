package co.idwall.iddog.data

import co.idwall.iddog.domain.GuideShop
import kotlinx.coroutines.*

class FeedRepository {
    suspend fun fetchFeed(): List<GuideShop> = withContext(Dispatchers.IO) {
        return@withContext RetrofitConfig().call.getShop()
    }
}



