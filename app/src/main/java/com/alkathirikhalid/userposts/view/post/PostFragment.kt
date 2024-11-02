package com.alkathirikhalid.userposts.view.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.alkathirikhalid.userposts.databinding.FragmentPostBinding
import com.alkathirikhalid.userposts.model.Post
import com.alkathirikhalid.userposts.model.User
import com.alkathirikhalid.userposts.viewmodel.PostViewModel

/**
 *
 * @author alkathirikhalid
 * @project User Posts
 * @date 01/11/2024
 */

class PostFragment : Fragment() {

    private val args: PostFragmentArgs by navArgs()

    private var _binding: FragmentPostBinding? = null
    private val binding get() = _binding!! // This property is only valid between onCreateView and onDestroyView.

    private val viewModel: PostViewModel by activityViewModels()

    private val postAdapter = PostAdapter(arrayListOf()) // empty

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPostBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetched(args.user)

        binding.rvPosts.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = postAdapter
        }




        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.user.observe(viewLifecycleOwner) { user: User ->
            user.let {
                binding.user = user
                postAdapter.refreshClear()
                postAdapter.updatePosts(user.posts as ArrayList<Post>)
            }
        }
    }

}