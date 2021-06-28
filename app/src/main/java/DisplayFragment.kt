package com.example.mysunflower

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.mysunflower.adapter.DisplayAdapter
import dagger.hilt.android.AndroidEntryPoint
import com.example.mysunflower.databinding.FragmentDisplayBinding
import com.example.mysunflower.viewmodel.DisplayViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DisplayFragment: Fragment() {

    private val adapter = DisplayAdapter()
    private val args: DisplayFragmentArgs by navArgs()
    // 用于取消正在进行的工作，避免内存泄漏或者UI异常
    private var searchJobs: Job? = null
    private lateinit var binding: FragmentDisplayBinding
    private val viewModel: DisplayViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 获取binding实例
        binding = FragmentDisplayBinding.inflate(inflater, container, false)
        binding.photoList.adapter = adapter
        search(args.query)
        return binding.root
    }

    private fun search(query: String){
        searchJobs?.cancel()
        searchJobs = lifecycleScope.launch {
            viewModel.search(query).collectLatest {data -> adapter.submitData(data) }
        }
    }
}