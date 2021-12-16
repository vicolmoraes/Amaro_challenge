package co.idwall.iddog.presentation.feed

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.idwall.iddog.R
import co.idwall.iddog.domain.GuideShop
import kotlinx.android.synthetic.main.item_feed.view.*

class AdressAdapter(
    val items: List<GuideShop>,
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
        fun bind(item: GuideShop) {

            itemVieww.tv_name.text = item.name
            itemVieww.tv_adress.text = item.address
        }
    }
}