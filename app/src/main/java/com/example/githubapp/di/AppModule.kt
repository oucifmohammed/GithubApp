package com.example.githubapp.di

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.githubapp.R
import com.example.githubapp.data.remote.Api
import com.example.githubapp.other.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): Api =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)

    @Provides
    @Singleton
    fun provideGlideInstance(
            @ApplicationContext context: Context
    ) = Glide.with(context).setDefaultRequestOptions(
            RequestOptions()
                    .placeholder(R.drawable.repo_image)
                    .error(R.drawable.repo_image)
    )
}