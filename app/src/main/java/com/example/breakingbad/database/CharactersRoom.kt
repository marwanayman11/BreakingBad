package com.example.breakingbad.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CharactersDao{
    @Query("SELECT * FROM characterdatabase ORDER BY id")
    fun getCharacters(): LiveData<List<CharacterDatabase>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg characters : CharacterDatabase)
}

@Database(entities = [CharacterDatabase::class], version = 2)
abstract class CharactersRoom : RoomDatabase(){
    abstract val charactersDao:CharactersDao
}

private lateinit var INSTANCE: CharactersRoom
fun getDatabase(context: Context):CharactersRoom{
    synchronized(CharactersRoom::class.java){
        if(!::INSTANCE.isInitialized){
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                CharactersRoom::class.java,
                "characters"
            ).fallbackToDestructiveMigration().build()
        }
    }
    return INSTANCE
}
