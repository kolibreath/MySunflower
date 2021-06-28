package com.example.mysunflower.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mysunflower.data.UnsplashPhoto
import com.example.mysunflower.databinding.ListItemPhotoBinding

class DisplayAdapter: PagingDataAdapter<UnsplashPhoto, DisplayAdapter.DisplayViewHolder>(DisplayDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisplayViewHolder {
        return DisplayViewHolder(
            ListItemPhotoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DisplayViewHolder, position: Int) {
        val photo = getItem(position)
        if (photo != null) holder.bind(photo)
    }

    class DisplayViewHolder(
        private val binding: ListItemPhotoBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            //todo navigate to DetailFragment
//             binding.setClickListener {  }
        }

        fun bind(item: UnsplashPhoto) {
            binding.apply {
                photo = item
                executePendingBindings()
            }
        }
    }

    private class DisplayDiffCallback: DiffUtil.ItemCallback<UnsplashPhoto>() {
        override fun areItemsTheSame(oldItem: UnsplashPhoto, newItem: UnsplashPhoto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UnsplashPhoto, newItem: UnsplashPhoto): Boolean {
            return oldItem == newItem
        }
    }
}
