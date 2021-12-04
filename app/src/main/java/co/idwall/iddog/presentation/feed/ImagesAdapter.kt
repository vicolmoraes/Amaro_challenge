package co.idwall.iddog.presentation.feed

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.idwall.iddog.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_feed.view.*

class ImagesAdapter(
    val items: List<String>,
    val context: Context
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ImagesViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_feed,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ImagesViewHolder).bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ImagesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemVieww = view
        fun bind(image: String) {

            Picasso.get().load(image).into(itemVieww.iv_dog);
        }
    }
}