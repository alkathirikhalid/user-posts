package com.alkathirikhalid.userposts.view

import android.view.View
import com.alkathirikhalid.userposts.model.User

/**
 *
 * @author alkathirikhalid
 * @project User Posts
 * @date 01/11/2024
 */
interface UserClickListener {
    fun onUserClicked(user: User, view: View)
}