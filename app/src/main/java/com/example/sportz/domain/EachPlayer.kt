package com.example.sportz.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class EachPlayer (
                         val teamName :String,
                         val isKeeper: Boolean = false,
                         val fullName: String,
                         val position: String,
                         val isCaptain: Boolean = false) : Parcelable {




}