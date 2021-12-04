package co.idwall.iddog.data

import co.idwall.iddog.domain.LoginBody
import co.idwall.iddog.domain.LoginResponse
import kotlinx.coroutines.*

class LoginRepository {
    suspend fun fetchLogin(chave: String): LoginResponse = withContext(Dispatchers.IO) {
        return@withContext RetrofitConfig().call.login(LoginBody(chave))
    }
}



