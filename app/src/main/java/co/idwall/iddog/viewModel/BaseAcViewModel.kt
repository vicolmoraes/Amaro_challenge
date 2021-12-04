package co.idwall.iddog.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseAcViewModel(): ViewModel(), CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext by lazy { job + Dispatchers.IO }

    override fun onCleared() {
        job.cancel()
        super.onCleared()
    }
}