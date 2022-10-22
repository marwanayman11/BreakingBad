package com.example.breakingbad.network

import com.example.breakingbad.database.CharacterDatabase
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterNetwork (
    @Json(name = "char_id")
    val id : Int,
    val name: String,
    val birthday : String,
    val img : String,
    val nickname: String,
    val occupation : List<String>,
    val appearance : List<Int>,
    val status : String
        )

@JsonClass(generateAdapter = true)
data class CharacterNetworkContainer(val characters : List<CharacterNetwork> )

fun CharacterNetworkContainer.asDatabaseModel():Array<CharacterDatabase>{
    return characters.map {
        CharacterDatabase(
            id = it.id,
            name = it.name,
            birthday = it.birthday,
            img = it.img,
            nickname = it.nickname,
            occupation = it.occupation.joinToString(prefix = "", postfix = ""),
            status = it.status,
            appearance = it.appearance.joinToString(prefix = "", postfix = "")
        )
    }.toTypedArray()
}

