package co.idwall.iddog.viewModel

import androidx.lifecycle.MutableLiveData
import co.idwall.iddog.data.LoginRepository
import co.idwall.iddog.domain.LoginResponse
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginViewModel(private val repository: LoginRepository) : BaseAcViewModel() {

    val actionState = MutableLiveData<ResponseState>()

    sealed class ResponseState {
        data class loginSucess(val response: LoginResponse) : ResponseState()
        data class loginError(val error: Exception) : ResponseState()
    }

    fun getUser(email: String) {
        launch {
            try {
                val response: LoginResponse = repository.fetchLogin(email)
                actionState.postValue(ResponseState.loginSucess(response))
            } catch (e: Exception) {
                actionState.postValue(ResponseState.loginError(e))
            }
        }
    }
}