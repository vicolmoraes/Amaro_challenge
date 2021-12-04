package co.idwall.iddog.viewModel

import androidx.lifecycle.MutableLiveData
import co.idwall.iddog.data.FeedRepository
import co.idwall.iddog.data.LoginRepository
import co.idwall.iddog.domain.DogFeed
import co.idwall.iddog.domain.LoginResponse
import kotlinx.coroutines.launch
import java.lang.Exception

class FeedViewModel(private val repository: FeedRepository) : BaseAcViewModel() {

    val actionState = MutableLiveData<ResponseState>()

    sealed class ResponseState {
        data class feedSucess(val response: DogFeed) : ResponseState()
        data class feedError(val error: Exception) : ResponseState()
    }

    fun getFeed(token: String, raca: String) {
        launch {
            try {
                val response: DogFeed = repository.fetchFeed(token, raca)
                actionState.postValue(ResponseState.feedSucess(response))
            } catch (e: Exception) {
                actionState.postValue(ResponseState.feedError(e))
            }
        }
    }
}