package com.alkathirikhalid.userposts.api

import com.alkathirikhalid.userposts.model.Post
import com.alkathirikhalid.userposts.model.User
import retrofit2.http.GET

/**
 *
 * @author alkathirikhalid
 * @project User Posts
 * @date 01/11/2024
 */
interface UserPostAPI {
    @GET("users")
    suspend fun getUsers(): List<User>

    @GET("posts")
    suspend fun getPosts(): List<Post>
}