package com.example.breakingbad.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.breakingbad.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        val binding = FragmentDetailBinding.inflate(layoutInflater)
        val character = DetailFragmentArgs.fromBundle(requireArguments()).character
        val viewModelFactory = DetailViewModelFactory(character)
        val viewModel = ViewModelProvider(this,viewModelFactory)[DetailViewModel::class.java]
        binding.viewModel = viewModel
        return binding.root
    }

}