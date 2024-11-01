package com.alkathirikhalid.userposts.model

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
)
