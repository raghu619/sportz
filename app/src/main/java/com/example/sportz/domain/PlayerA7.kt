package com.example.sportz.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlayerA7(
    val Iskeeper: Boolean = false,
    val Name_Full: String,
    val Position: String,
    val Iscaptain :Boolean = false
) : Parcelable