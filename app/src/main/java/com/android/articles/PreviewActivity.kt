package com.android.articles

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.android.articles.databinding.ActivityPreviewBinding


class PreviewActivity : AppCompatActivity() {

    private lateinit var binding:ActivityPreviewBinding
    private lateinit var viewModel: PreviewActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreviewBinding.inflate(LayoutInflater.from(this))
        binding.lifecycleOwner = this
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[PreviewActivityViewModel::class.java]
        handleIntent()
        binding.viewModel = viewModel
        setObservers()
    }
    private fun handleIntent() {
        if(intent.extras!=null && intent.extras!!.get("Article")!=null){
            viewModel.article.value = (intent.extras!!.get("Article") as ArticleParcelable).getEntity()
        }
        else finishActivity(0)
    }
    private fun setObservers(){
        viewModel.open.observe(this){ url->
            if(url!=null) {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(browserIntent)
                viewModel.open.value = null
            }
        }

    }

}