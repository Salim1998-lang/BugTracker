package com.example.bugtracker.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Bug(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val title: String,
    @SerializedName("status")
    val status: Status,
    @SerializedName("description")
    val description: String,
    @SerializedName("sender")
    val sender: Sender,
    @SerializedName("product")
    val product: Product,
    @SerializedName("version")
    val version: String
): Parcelable

@Parcelize
data class Status(
    @SerializedName("tooltip")
    val state: String
): Parcelable

@Parcelize
data class Product(
    @SerializedName("name")
    val name: String
):Parcelable

@Parcelize
data class Sender(
    @SerializedName("id")
    val id: Int,
    @SerializedName("username")
    val userName: String
):Parcelable


data class BugTracker(
@SerializedName("bug_trackers")
    val bugs: List<Bug>)






