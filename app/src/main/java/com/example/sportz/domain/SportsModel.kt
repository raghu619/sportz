package com.example.sportz.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class SportsModel(
    val Teams: Teams
) : Parcelable