package com.example.breakingbad

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val id: Int,
    val name: String,
    val birthday: String,
    val img: String,
    val nickname: String,
    val occupation: String,
    val appearance: String,
    val status: String
) : Parcelable
