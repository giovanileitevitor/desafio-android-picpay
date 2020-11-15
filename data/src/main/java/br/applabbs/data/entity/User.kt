package br.applabbs.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


data class User(
    var img: String?,
    var name: String?,
    var id: Int?,
    var username: String?
)