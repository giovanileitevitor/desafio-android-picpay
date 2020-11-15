package br.applabbs.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


data class UserResponse(
    val users: List<UserSchema>
)