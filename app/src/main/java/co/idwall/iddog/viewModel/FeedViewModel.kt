package co.idwall.iddog.viewModel

import androidx.lifecycle.MutableLiveData
import co.idwall.iddog.data.FeedRepository
import co.idwall.iddog.domain.GuideShop
import kotlinx.coroutines.launch
import java.lang.Exception

class FeedViewModel(private val repository: FeedRepository) : BaseAcViewModel() {

    val actionState = MutableLiveData<ResponseState>()

    sealed class ResponseState {
        data class feedSucess(val response: List<GuideShop>) : ResponseState()
        data class feedError(val error: Exception) : ResponseState()
    }

    fun getFeed() {
        launch {
            try {
                val response: List<GuideShop> = repository.fetchFeed()
                actionState.postValue(ResponseState.feedSucess(response))
            } catch (e: Exception) {
                actionState.postValue(ResponseState.feedError(e))
            }
        }
    }
}