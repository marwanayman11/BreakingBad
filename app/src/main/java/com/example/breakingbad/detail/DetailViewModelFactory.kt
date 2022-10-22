package com.example.breakingbad.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.breakingbad.Character

class DetailViewModelFactory(
    private val character: Character,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DetailViewModel(character) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
