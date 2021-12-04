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
        val token = arguments?.getString("token")!!

        initViews(token)
        initObserver()
    }

    private fun initViews(token: String) {
        bt_feed_pug.setOnClickListener {
            viewModel.getFeed(token, bt_feed_pug.text.toString())
        }
        bt_feed_labrador.setOnClickListener {
            viewModel.getFeed(token, bt_feed_labrador.text.toString())
        }
        bt_feed_husky.setOnClickListener {
            viewModel.getFeed(token, bt_feed_husky.text.toString())
        }
        bt_feed_hound.setOnClickListener {
            viewModel.getFeed(token, bt_feed_hound.text.toString())
        }
    }

    private fun initObserver() {
        viewModel.actionState.observe(viewLifecycleOwner, Observer {
            when (it) {
                is FeedViewModel.ResponseState.feedSucess -> {
                    val images = it.response.list
                    if (images != null) {
                        rv_feed.adapter = context?.let { it1 -> ImagesAdapter(images, it1) }
                    }
                }
                is FeedViewModel.ResponseState.feedError -> {
                    Toast.makeText(context, it.error.toString(), Toast.LENGTH_LONG)
                }
            }
        })
    }
}