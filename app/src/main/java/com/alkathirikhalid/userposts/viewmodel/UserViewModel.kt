package com.alkathirikhalid.userposts.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.alkathirikhalid.userposts.api.UserPostAPIService
import com.alkathirikhalid.userposts.model.Post
import com.alkathirikhalid.userposts.model.User
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

/**
 *
 * @author alkathirikhalid
 * @project User Posts
 * @date 01/11/2024
 */
class UserViewModel(application: Application) : BaseViewModel(application) {

    val loading = MutableLiveData<Boolean>()
    val usersLoadingError = MutableLiveData<Boolean>()
    val users = MutableLiveData<List<User>>()
    val posts = MutableLiveData<List<Post>>()

    private val userPostAPIService = UserPostAPIService()

    fun fetchFromRemote() {
        loading.value = true
        viewModelScope.launch {
            userPostAPIService.getUsers()
                .catch { e ->
                    usersLoadingError.value = true
                    loading.value = false
                }
                .collect { data ->
                    users.value = data
                    userPosts()
                }
        }
    }

    private fun userPosts() {
        loading.value = true
        viewModelScope.launch {
            userPostAPIService.getPosts()
                .catch { e ->
                    usersLoadingError.value = true
                    loading.value = false
                }
                .collect { data ->
                    posts.value = data

                    // Calculate post count for each userId
                    val postCounts = data.groupingBy { it.userId }.eachCount()

                    // Match and add the users' posts
                    val postsByUserId = data.groupBy { it.userId }

                    // Update users list with post counts and posts
                    users.value = users.value?.map { user ->
                        val userPosts = postsByUserId[user.userId] ?: emptyList()
                        user.copy(
                            postCount = postCounts[user.userId] ?: 0,
                            posts = userPosts // Add the list of posts
                        )
                    }

                    loading.value = false
                }
        }
    }


}