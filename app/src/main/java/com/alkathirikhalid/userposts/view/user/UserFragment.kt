package com.alkathirikhalid.userposts.view.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.alkathirikhalid.userposts.databinding.FragmentUserBinding
import com.alkathirikhalid.userposts.model.User
import com.alkathirikhalid.userposts.viewmodel.UserViewModel

/**
 *
 * @author alkathirikhalid
 * @project User Posts
 * @date 01/11/2024
 */
class UserFragment : Fragment() {

    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!! // This property is only valid between onCreateView and onDestroyView.

    private val viewModel: UserViewModel by activityViewModels()

    private val userAdapter = UserAdapter(arrayListOf()) // empty

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchFromRemote()

        binding.rvUsers.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = userAdapter
        }

        binding.refreshLayout.setOnRefreshListener {
            binding.rvUsers.visibility = View.GONE
            binding.tvError.visibility = View.GONE
            binding.pbLoading.visibility = View.GONE

            viewModel.fetchFromRemote()

            binding.refreshLayout.isRefreshing = false
        }

        observeViewModel()

    }

    private fun observeViewModel() {
        viewModel.users.observe(viewLifecycleOwner) { users: List<User> ->
            users.let {
                binding.rvUsers.visibility = View.VISIBLE
                userAdapter.refreshClear()// For Test / Demo
                userAdapter.updateUsers(users as ArrayList<User>)
            }
        }
        viewModel.usersLoadingError.observe(viewLifecycleOwner) { isError: Boolean ->
            isError.let {
                binding.tvError.visibility = if (it) View.VISIBLE else View.GONE
            }
        }
        viewModel.loading.observe(viewLifecycleOwner) { isLoading: Boolean ->
            isLoading.let {
                binding.pbLoading.visibility = if (it) View.VISIBLE else View.GONE
                if (it) {
                    binding.tvError.visibility = View.GONE
                    binding.rvUsers.visibility = View.GONE
                }
            }
        }
    }

}
