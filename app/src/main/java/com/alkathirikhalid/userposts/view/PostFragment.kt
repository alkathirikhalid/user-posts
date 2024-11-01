package com.alkathirikhalid.userposts.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alkathirikhalid.userposts.R
import com.alkathirikhalid.userposts.model.User

/**
 *
 * @author alkathirikhalid
 * @project User Posts
 * @date 01/11/2024
 */

class PostFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val user = args.user
        val user = arguments?.getSerializable("user") as User?
        if (user != null) {
            Log.d("USER Kaled: ", user.name)
        }
        // Use the user object as needed
    }

}