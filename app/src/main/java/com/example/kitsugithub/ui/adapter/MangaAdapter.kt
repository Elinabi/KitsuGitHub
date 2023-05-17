package com.example.kitsugithub.ui.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kitsugithub.models.DataItem
import com.example.kitsugithub.databinding.ItemKitsuBinding
import com.example.kitsugithub.extension.setImage

class MangaAdapter(val onItemClick: (id: String) -> Unit):
    PagingDataAdapter<DataItem, MangaAdapter.ViewHolder>(
    AnimeDiffCallBack
) {
    inner class ViewHolder(private val binding: ItemKitsuBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition)?.let { anime -> onItemClick(anime.id) }
            }
        }

        fun onBind(item: DataItem) {
            binding.itemText.text = item.attributes.titles.enJp
            binding.itemImage.setImage(item.attributes.posterImage.original)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemKitsuBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    object AnimeDiffCallBack : DiffUtil.ItemCallback<DataItem>() {
        override fun areItemsTheSame(
            oldItem: DataItem,
            newItem: DataItem,
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: DataItem,
            newItem: DataItem,
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }
}