package com.alkathirikhalid.userposts.view.user

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.alkathirikhalid.userposts.R
import com.alkathirikhalid.userposts.databinding.UserItemLayoutBinding
import com.alkathirikhalid.userposts.model.User

/**
 *
 * @author alkathirikhalid
 * @project User Posts
 * @date 01/11/2024
 */
class UserAdapter(private val users: ArrayList<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>(), UserClickListener {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.user_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        holder.binding.user = users[position]
        holder.binding.listener = this

        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun updateUsers(newUsers: ArrayList<User>) {
        users.addAll(itemCount, newUsers)
        notifyItemRangeChanged(itemCount, newUsers.size)
    }

    fun refreshClear() {
        users.clear()
        notifyDataSetChanged()
    }

    class UserViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        val binding: UserItemLayoutBinding = UserItemLayoutBinding.bind(view)
    }

    override fun onUserClicked(user: User, view: View) {
        view.findNavController()
            .navigate(UserFragmentDirections.actionUserFragmentToPostFragment(user))
    }
}