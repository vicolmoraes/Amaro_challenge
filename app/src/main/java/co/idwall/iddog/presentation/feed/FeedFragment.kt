package co.idwall.iddog.presentation.feed

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import co.idwall.iddog.R
import co.idwall.iddog.viewModel.FeedViewModel
import kotlinx.android.synthetic.main.fragment_feed.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FeedFragment : Fragment(R.layout.fragment_feed) {
    private val viewModel: FeedViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getFeed()
        initObserver()
    }

    private fun initObserver() {
        viewModel.actionState.observe(viewLifecycleOwner, Observer {
            when (it) {
                is FeedViewModel.ResponseState.feedSucess -> {
                    val itemAdress = it.response
                    rv_feed.adapter = context?.let { it1 -> AdressAdapter(itemAdress, it1) }
                }
                is FeedViewModel.ResponseState.feedError -> {
                    Toast.makeText(context, it.error.toString(), Toast.LENGTH_LONG)
                }
            }
        })
    }
}
