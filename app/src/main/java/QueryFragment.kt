package com.example.mysunflower

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mysunflower.databinding.FragmentQueryBinding
import com.example.mysunflower.viewmodel.DisplayViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class QueryFragment: Fragment() {

    private val displayViewModel: DisplayViewModel by viewModels()
    private lateinit var binding: FragmentQueryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQueryBinding.inflate(inflater, container, false)
        binding.buttonQuery.setOnClickListener {
            navigateToDisplay()
        }
        return binding.root
    }

    private fun navigateToDisplay(){
        val query = binding.editQuery.text.toString()
        val direction = QueryFragmentDirections.actionQueryToDisplay(query)
        findNavController().navigate(direction)
    }
}