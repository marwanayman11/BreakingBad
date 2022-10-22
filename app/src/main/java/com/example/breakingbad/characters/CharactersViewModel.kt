package com.example.breakingbad.characters

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.breakingbad.database.getDatabase
import com.example.breakingbad.repository.Repository
import kotlinx.coroutines.launch
import timber.log.Timber
import com.example.breakingbad.Character

class CharactersViewModel(application: Application) : AndroidViewModel(application) {
    private val database = getDatabase(application)
    private val repository = Repository(database)
    private val _navigateToSelectedCharacter = MutableLiveData<Character?>()
    val navigateToSelectedCharacter : LiveData<Character?>
    get() = _navigateToSelectedCharacter
    val characters = repository.characters
    init {
        getCharacters()
    }
    private fun getCharacters(){
        viewModelScope.launch {
            try {
                repository.refreshCharacters()
            }catch (e : Exception){
                Timber.e("no connection")
            }
        }
    }
    fun displayCharacterDetails(character: Character){
        _navigateToSelectedCharacter.value = character
    }
    fun displayCharacterDetailsComplete(){
        _navigateToSelectedCharacter.value = null
    }
}