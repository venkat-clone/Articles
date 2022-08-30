package com.android.articles


import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.articles.retrofit.ArticleAPI
import com.android.articles.retrofit.ArticleEntity
import com.android.articles.retrofit.RetrofitRepository
import com.android.articles.retrofit.RetrofitServices


class MainActivityViewModel : ViewModel() {
    val articleList:MutableLiveData<List<ArticleEntity>> = MutableLiveData<List<ArticleEntity>>()

    val openArticle:MutableLiveData<ArticleEntity> = MutableLiveData<ArticleEntity>()
    val code:MutableLiveData<Int> = MutableLiveData<Int>(0)

    private val repository:RetrofitRepository =
        RetrofitRepository(RetrofitServices.CreateRetrofitServices().create(ArticleAPI::class.java))

    fun fetchData(){
        code.postValue(0)
        repository.getArticles(articleList,code)
    }
    fun retry(v: View){
        fetchData()
    }

}