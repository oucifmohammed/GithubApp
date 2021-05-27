package com.example.githubapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubapp.adapters.GithubAdapter
import com.example.githubapp.adapters.RepositoriesLoadStateAdapter
import com.example.githubapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: GithubViewModel

    @Inject
    lateinit var repositoryAdapter: GithubAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        viewModel = ViewModelProvider(this).get(GithubViewModel::class.java)

        viewModel.searchRepositories()

        setupUiUpdate()

        subscribeToLiveData()


    }

    private fun setupRecyclerView(){
        binding.repositoryList.apply {
            adapter = repositoryAdapter.withLoadStateFooter(
                footer = RepositoriesLoadStateAdapter{
                    repositoryAdapter.retry()
                }
            )
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }

    private fun subscribeToLiveData(){
        viewModel.githubRepositories.observe(this) {
            repositoryAdapter.submitData(lifecycle,it)
        }
    }

    private fun setupUiUpdate(){
        repositoryAdapter.addLoadStateListener {
            binding.apply {
                progressBar.isVisible = it.source.refresh is LoadState.Loading
                retryButton.isVisible = it.source.refresh is LoadState.Error
            }
        }

        binding.retryButton.setOnClickListener {
            repositoryAdapter.retry()
        }
    }
}