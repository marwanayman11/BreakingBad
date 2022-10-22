package com.example.breakingbad.characters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.breakingbad.adapters.CharactersAdapter
import com.example.breakingbad.databinding.FragmentCharactersBinding


class CharactersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        val binding = FragmentCharactersBinding.inflate(layoutInflater)
        val application = requireNotNull(this.activity).application
        val viewModelFactory = CharactersViewModelFactory(application)
        val viewModel = ViewModelProvider(this,viewModelFactory)[CharactersViewModel::class.java]
        val adapter = CharactersAdapter(CharactersAdapter.OnClickListener{
           viewModel.displayCharacterDetails(it)
        })
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.characters.adapter = adapter
        viewModel.navigateToSelectedCharacter.observe(viewLifecycleOwner){
            if(null != it){
                this.findNavController().navigate(CharactersFragmentDirections.actionCharactersFragmentToDetailFragment(it))
                viewModel.displayCharacterDetailsComplete()
            }
        }
        return binding.root
    }

}