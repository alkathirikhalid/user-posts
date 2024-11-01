package com.alkathirikhalid.userposts.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alkathirikhalid.userposts.R
import com.alkathirikhalid.userposts.api.UserPostAPIService

class MainActivity : AppCompatActivity() {
    private val userPostAPIService = UserPostAPIService()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userPostAPIService.getUsers() // test log

    }
}