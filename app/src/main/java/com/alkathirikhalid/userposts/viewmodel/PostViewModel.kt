package com.alkathirikhalid.userposts.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.alkathirikhalid.userposts.model.User
import kotlinx.coroutines.launch

/**
 *
 * @author alkathirikhalid
 * @project User Posts
 * @date 01/11/2024
 */
class PostViewModel(application: Application) : BaseViewModel(application) {
    val user = MutableLiveData<User>()

    fun fetched(receivedUser: User) {
        launch { user.value = receivedUser }
    }
}