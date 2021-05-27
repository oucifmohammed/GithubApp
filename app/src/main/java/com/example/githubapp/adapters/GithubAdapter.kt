package com.example.githubapp.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.githubapp.databinding.LayoutItemBinding
import javax.inject.Inject

class GithubAdapter @Inject constructor(
    val glide: RequestManager
): RecyclerView.Adapter<GithubAdapter.RepositoryViewHolder>(){

    class RepositoryViewHolder(private var binding: LayoutItemBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}