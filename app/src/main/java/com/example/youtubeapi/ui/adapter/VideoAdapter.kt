package com.example.youtubeapi.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.youtubeapi.data.model.video.VideoModel
import com.example.youtubeapi.databinding.OneVideoItemBinding

class VideoAdapter:
    ListAdapter<VideoModel, VideoAdapter.CategoryViewHolder>(DiffUtilCallback()) {

    inner class CategoryViewHolder(private val binding: OneVideoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: VideoModel) = with(binding) {
            Glide.with(binding.imageView.context)
                .load(item.snippet.thumbnails.standard.url)
                .into(binding.imageView)

            Glide.with(binding.imageView2.context)
                .load(item.snippet.thumbnails.standard.url)
                .into(binding.imageView2)

            binding.name.text = item.snippet.localized.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            OneVideoItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {

        class DiffUtilCallback : DiffUtil.ItemCallback<VideoModel>() {

            override fun areItemsTheSame(oldItem: VideoModel, newItem: VideoModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: VideoModel, newItem: VideoModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}
