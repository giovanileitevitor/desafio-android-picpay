package br.applabbs.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


data class UserSchema(
    val img: String?,
    val name: String?,
    val id: Int?,
    val username: String?
)