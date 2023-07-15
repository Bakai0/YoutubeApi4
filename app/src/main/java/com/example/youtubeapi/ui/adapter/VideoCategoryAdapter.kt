package com.example.youtubeapi.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapi.data.model.category.VideoCategory
import com.example.youtubeapi.databinding.OneItemBinding

class VideoCategoryAdapter (private val onItemClick: (id: String?) -> Unit) :
    ListAdapter<VideoCategory, VideoCategoryAdapter.YoutubeViewHolder>(DiffUtilCallback()) {

    inner class YoutubeViewHolder(private val binding: OneItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.tvTitle.setOnClickListener {
                val item: VideoCategory? = getItem(absoluteAdapterPosition)
                onItemClick(item?.id)
            }
        }

        fun onBind(item: VideoCategory) = with(binding) {
            tvTitle.text = item.snippet.title.trim()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YoutubeViewHolder {
        return YoutubeViewHolder(
            OneItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: YoutubeViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {

        class DiffUtilCallback : DiffUtil.ItemCallback<VideoCategory>() {

            override fun areItemsTheSame(
                oldItem: VideoCategory,
                newItem: VideoCategory
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: VideoCategory,
                newItem: VideoCategory
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}
