package com.android.articles


import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.articles.retrofit.ArticleEntity

class PreviewActivityViewModel(application: Application):AndroidViewModel(application) {


    
    var article: MutableLiveData<ArticleEntity> = MutableLiveData<ArticleEntity>()
    var open: MutableLiveData<String> = MutableLiveData<String>()
    fun openArticle(v: View){
        open.postValue(article.value!!.url)
    }
}