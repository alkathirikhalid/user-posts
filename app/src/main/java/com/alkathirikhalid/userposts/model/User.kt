package com.alkathirikhalid.userposts.model

/**
 *
 * @author alkathirikhalid
 * @project User Posts
 * @date 01/11/2024
 */
data class User(
    val albumId: Int,
    val userId: Int,
    val name: String,
    val url: String,
    val thumbnailUrl: String,
    val postCount: Int = 0 // Added postCount property
)
