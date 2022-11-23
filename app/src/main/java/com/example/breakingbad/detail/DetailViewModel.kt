package com.example.breakingbad.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.breakingbad.Character

class DetailViewModel(character: Character) : ViewModel() {
    private val _selectedCharacter = MutableLiveData<Character>()
    val selectedCharacter: LiveData<Character>
        get() = _selectedCharacter

    init {
        _selectedCharacter.value = character
    }
}