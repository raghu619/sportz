package com.example.sportz.domain

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


@Parcelize
data class SportsModel(
     @Json(name = "Teams")
    val teams: Map<String,TeamModel>
) : Parcelable