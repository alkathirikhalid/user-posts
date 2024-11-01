package com.alkathirikhalid.userposts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alkathirikhalid.userposts.R
import com.alkathirikhalid.userposts.databinding.PostItemLayoutBinding
import com.alkathirikhalid.userposts.model.Post

/**
 *
 * @author alkathirikhalid
 * @project User Posts
 * @date 01/11/2024
 */
class PostAdapter(private val posts: ArrayList<Post>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.post_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        holder.binding.post = posts[position]

        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    fun updatePosts(newPosts: ArrayList<Post>) {
        posts.addAll(itemCount, newPosts)
        notifyItemRangeChanged(itemCount, newPosts.size)
    }

    fun refreshClear() {
        posts.clear()
        notifyDataSetChanged()
    }

    class PostViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        val binding: PostItemLayoutBinding = PostItemLayoutBinding.bind(view)
    }

}