package com.example.sportz.domain

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Teams(
    @Json(name = "4")
 val teamA: TeamA,
    @Json(name = "5")
    val teamB: TeamB
) :  Parcelable {

}