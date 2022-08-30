package com.android.articles.retrofit


import com.android.articles.BuildConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleAPI {
    @GET("emailed/1.json")
    fun getArticles(@Query("api-key") api:String = BuildConfig.API_KEY) : Call<ArticleResponse>

}