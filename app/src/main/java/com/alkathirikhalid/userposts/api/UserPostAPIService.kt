package com.alkathirikhalid.userposts.api

import com.alkathirikhalid.userposts.model.Post
import com.alkathirikhalid.userposts.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *
 * @author alkathirikhalid
 * @project User Posts
 * @date 01/11/2024
 */
class UserPostAPIService {
    private val BASEURL = "https://my-json-server.typicode.com/SharminSirajudeen/test_resources/"

    private fun getHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        var httpClient = OkHttpClient()


        httpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return httpClient
    }

    private val api = Retrofit.Builder()
        .baseUrl(BASEURL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(getHttpClient())
        .build()
        .create(UserPostAPI::class.java)

    fun getUsers(): Flow<List<User>> = flow {
        emit(api.getUsers())
    }

    fun getPosts(): Flow<List<Post>> = flow {
        emit(api.getPosts())
    }
}