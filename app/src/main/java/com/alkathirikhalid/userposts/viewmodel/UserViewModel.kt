package com.alkathirikhalid.userposts.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.alkathirikhalid.userposts.api.UserPostAPIService
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
                }
        }
    }
}