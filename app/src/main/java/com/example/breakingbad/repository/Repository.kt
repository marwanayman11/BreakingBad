package com.example.breakingbad.repository
import com.example.breakingbad.Character
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.breakingbad.database.CharactersRoom
import com.example.breakingbad.database.asDomainModel
import com.example.breakingbad.network.Api
import com.example.breakingbad.network.CharacterNetworkContainer
import com.example.breakingbad.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository(private val database: CharactersRoom) {
    val characters : LiveData<List<Character>> = Transformations.map(database.charactersDao.getCharacters()){
        it.asDomainModel()
    }
    suspend fun refreshCharacters(){
        withContext(Dispatchers.IO){
            val result = Api.retrofitService.getCharacters()
            val container = CharacterNetworkContainer(result)
            database.charactersDao.insertAll(*container.asDatabaseModel())
        }
    }
}