package com.example.sportz.domain

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


@Parcelize
data class TeamModel(
    @Json(name = "Name_Full")
    val fullName: String,
    @Json(name = "Name_Short")
    val shortName: String,
    @Json(name = "Players")
    val players: Map<String, EachPlayer>
) : Parcelable
