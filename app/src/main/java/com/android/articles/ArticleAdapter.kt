package com.android.articles

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.articles.databinding.ArticleCardBinding
import com.android.articles.retrofit.ArticleEntity
import kotlin.coroutines.coroutineContext

class ArticleAdapter(private val context: Context, private val Articles: List<ArticleEntity>,val videModel: MainActivityViewModel): RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ArticleCardBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.data = Articles[position]
        holder.binding.root.setOnClickListener{
            videModel.openArticle.postValue(Articles[position])
        }
    }

    override fun getItemCount(): Int {
        return Articles.size
    }
    class ViewHolder(val binding: ArticleCardBinding) : RecyclerView.ViewHolder(binding.root)
}