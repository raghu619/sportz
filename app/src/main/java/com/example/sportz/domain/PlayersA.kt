package com.example.sportz.domain

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlayersA(
    @Json(name = "3632")
    val playerA1: PlayerA1,
    @Json(name = "3722")
    val playerA2: PlayerA2,
    @Json(name = "3852")
    val playerA3: PlayerA3,
    @Json(name = "4176")
    val playerA4: PlayerA4,
    @Json(name = "4532")
    val playerA5: PlayerA5,
    @Json(name = "5132")
    val playerA6: PlayerA6,
    @Json(name = "63187")
    val playerA7: PlayerA7,
    @Json(name = "63751")
    val playerA8: PlayerA8,
    @Json(name = "65867")
    val playerA9: PlayerA9,
    @Json(name = "66818")
    val playerA10: PlayerA10,
    @Json(name = "9844")
    val playerA11: PlayerA11
) : Parcelable