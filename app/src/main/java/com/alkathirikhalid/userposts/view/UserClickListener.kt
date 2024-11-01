package com.alkathirikhalid.userposts.view

import android.view.View

/**
 *
 * @author alkathirikhalid
 * @project User Posts
 * @date 01/11/2024
 */
interface UserClickListener {
    fun onUserClicked(userId: Int, view: View)
}