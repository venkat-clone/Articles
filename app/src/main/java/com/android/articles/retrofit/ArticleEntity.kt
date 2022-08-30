package com.android.articles.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ArticleEntity(
    @SerializedName("url")
    @Expose
    var url: String,
    @SerializedName("id")
    @Expose
    var id: Long,
    @SerializedName("source")
    @Expose
    var source: String,
    @SerializedName("title")
    @Expose
    var title: String,
    @SerializedName("abstract")
    @Expose
    var abstract: String,
    @SerializedName("updated")
    @Expose
    var updated: String,
    @SerializedName("byline")
    @Expose
    var byline: String,

    )

data class ArticleResponse(
    @SerializedName("num_results")
    @Expose
    var num_results: Int,
    @SerializedName("results")
    @Expose
    var results: List<ArticleEntity>
)


