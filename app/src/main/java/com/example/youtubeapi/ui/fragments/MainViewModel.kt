package com.example.youtubeapi.ui.fragments

import androidx.lifecycle.ViewModel
import com.example.youtubeapi.data.repository.VideoCategoryRepository
import com.example.youtubeapi.data.repository.VideoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel  @Inject constructor(
    private val repository: VideoCategoryRepository,
    private val searchRepository: VideoRepository
) : ViewModel() {

    fun fetchVideoCategory() = repository.fetchVideoCategory()

    fun fetchVideo(id: String?) = searchRepository.fetchVideo(id)
}