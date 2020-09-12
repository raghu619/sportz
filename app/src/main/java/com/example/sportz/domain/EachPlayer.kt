package com.example.sportz.domain

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


@Parcelize
data class EachPlayer(
    val teamName :String ="",
    @Json(name = "Iskeeper")
    val isKeeper: Boolean = false,
    @Json(name = "Name_Full")
    val fullName: String,
    @Json(name = "Position")
    val position: String,
    @Json(name = "Iscaptain")
    val isCaptain: Boolean = false
) : Parcelable {


}