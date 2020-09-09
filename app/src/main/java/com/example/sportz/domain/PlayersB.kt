package com.example.sportz.domain

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlayersB(
    @Json(name = "10167")
    val playerB1: PlayerB1,

    @Json(name = "10172")
    val playerB2: PlayerB2,
    @Json(name = "11703")
    val playerB3: PlayerB3,
    @Json(name = "11706")
    val playerB4: PlayerB4,
    @Json(name = "3752")
    val playerB5: PlayerB5,
    @Json(name = "4330")
    val playerB6: PlayerB6,
    @Json(name = "4338")
    val playerB7: PlayerB7,
    @Json(name = "4964")
    val playerB8: PlayerB8,
    @Json(name = "57594")
    val playerB9: PlayerB9,
    @Json(name = "57903")
    val playerB10: PlayerB10,
    @Json(name = "60544")
    val playerB11: PlayerB11





) : Parcelable