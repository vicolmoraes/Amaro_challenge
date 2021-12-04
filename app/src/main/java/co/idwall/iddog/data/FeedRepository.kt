package co.idwall.iddog.data

import co.idwall.iddog.domain.DogFeed
import kotlinx.coroutines.*

class FeedRepository {
    suspend fun fetchFeed(token: String, raca: String): DogFeed = withContext(Dispatchers.IO) {
        return@withContext RetrofitConfig().call.getFeed(token, raca)
    }
}



