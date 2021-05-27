package com.example.githubapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.githubapp.data.remote.Item
import com.example.githubapp.databinding.LayoutItemBinding
import javax.inject.Inject

class GithubAdapter @Inject constructor(
    val glide: RequestManager
) : PagingDataAdapter<Item, GithubAdapter.RepositoryViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val binding: LayoutItemBinding =
            LayoutItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return RepositoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }


    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class RepositoryViewHolder(private var binding: LayoutItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) = with(item) {

            binding.apply {
                repoTitle.text = item.name
                repoOwnerName.text = item.owner.login
                repoDesc.text = item.description
                numStars.text = item.watchers.toString()
            }

            glide.load(item.owner.avatar_url).into(binding.repoImage)
        }
    }
}