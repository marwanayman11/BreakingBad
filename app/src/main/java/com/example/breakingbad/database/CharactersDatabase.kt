package com.example.breakingbad.database

import com.example.breakingbad.Character
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CharacterDatabase constructor(
    @PrimaryKey
    val id: Int,
    val name: String,
    val birthday: String,
    val img: String,
    val nickname: String,
    val occupation: String,
    val appearance: String,
    val status: String
)

fun List<CharacterDatabase>.asDomainModel(): List<Character> {
    return map {
        Character(
            id = it.id,
            name = it.name,
            birthday = it.birthday,
            img = it.img,
            nickname = it.nickname,
            status = it.status,
            occupation = it.occupation,
            appearance = it.appearance
        )
    }
}