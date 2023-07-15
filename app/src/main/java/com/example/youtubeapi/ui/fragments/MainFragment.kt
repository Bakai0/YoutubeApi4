package com.example.youtubeapi.ui.fragments

import android.content.ContentValues
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.youtubeapi.R
import com.example.youtubeapi.base.BaseFragment
import com.example.youtubeapi.databinding.FragmentMainBinding
import com.example.youtubeapi.ui.adapter.VideoAdapter
import com.example.youtubeapi.ui.adapter.VideoCategoryAdapter
import com.example.youtubeapi.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>(R.layout.fragment_main) {

    override val viewBinding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)
    override val viewModel: MainViewModel by viewModels()
    private val videoCategoryAdapter = VideoCategoryAdapter(this::onItemCLick)
    private val videoAdapter = VideoAdapter()

    private fun onItemCLick(id: String?) {
        viewModel.fetchVideo(id).observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error ->
                    Log.e(ContentValues.TAG, "error")
                is Resource.Loading ->
                    Log.e(ContentValues.TAG, "loading")
                is Resource.Success ->
                    videoAdapter.submitList(it.data?.items)
            }
        }
    }

    override fun initialize() {
        viewBinding.recyclerViewVideoCategory.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = videoCategoryAdapter
        }

        viewBinding.recyclerViewVideo.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = videoAdapter
        }
    }

    override fun setupSubscribes() {
        videoCategorySubscribe()
        videoSubscribe()
    }

    private fun videoCategorySubscribe() {
        viewModel.fetchVideoCategory().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error ->
                    Log.e(ContentValues.TAG, "error")
                is Resource.Loading ->
                    Log.e(ContentValues.TAG, "loading")
                is Resource.Success ->
                    videoCategoryAdapter.submitList(it.data?.items)
            }
        }
    }

    private fun videoSubscribe() {
        viewModel.fetchVideo("0").observe(viewLifecycleOwner) { it ->
            when (it) {
                is Resource.Error ->
                    Log.e(ContentValues.TAG, "error")
                is Resource.Loading ->
                    Log.e(ContentValues.TAG, "loading")
                is Resource.Success ->
                    videoAdapter.submitList(it.data?.items)
            }
        }
    }
}