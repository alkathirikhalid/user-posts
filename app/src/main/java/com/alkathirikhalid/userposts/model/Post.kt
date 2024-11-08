package com.alkathirikhalid.userposts.model

import android.os.Parcel
import android.os.Parcelable

/**
 *
 * @author alkathirikhalid
 * @project User Posts
 * @date 01/11/2024
 */
data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(userId)
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(body)
    }

    override fun describeContents(): Int = 0
    class PostCreator : Parcelable.Creator<Post> {
        override fun createFromParcel(parcel: Parcel): Post {
            return Post(parcel)
        }

        override fun newArray(size: Int): Array<Post?> {
            return arrayOfNulls(size)
        }
    }
}
