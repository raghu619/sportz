package com.example.sportz.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TeamA(
    val Name_Full: String,
    val Name_Short: String,
    val Players: PlayersA
) : Parcelable