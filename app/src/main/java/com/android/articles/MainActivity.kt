package com.android.articles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.android.articles.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mainViewModel:MainActivityViewModel? = null

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        binding.lifecycleOwner =this
        setViewModel()
        setContentView(binding.root)
        binding.viewModel = mainViewModel
        setObserver()
    }

    private fun setViewModel(){
        mainViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        mainViewModel!!.fetchData()

    }
    private fun setObserver(){
        mainViewModel!!.articleList.observe(this){ list->
            binding.progress.visibility = View.GONE
            if(list!=null) {
                binding.recyclerView.adapter = ArticleAdapter(this,list,mainViewModel!!)
            }
        }
        mainViewModel!!.openArticle.observe(this){ articleEntity ->
            if(articleEntity!=null){
                val intent = Intent(this, PreviewActivity::class.java)
                intent.putExtra("Article", ArticleParcelable(articleEntity))
                startActivity(intent)
                mainViewModel!!.openArticle.postValue(null)

            }


        }
    }
}