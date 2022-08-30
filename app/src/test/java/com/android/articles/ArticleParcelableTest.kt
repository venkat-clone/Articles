package com.android.articles



import com.android.articles.retrofit.ArticleEntity
import org.junit.Assert

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ArticleParcelableTest{
    @Test
    fun `parcelable `(){
        val v = ArticleEntity(
            "url//",
            120,"DDD",
            "abs","abstract",
            "90 / 80/80","by me"
        )
        val result = ArticleParcelable(v)

        Assert.assertTrue(result.getEntity()==v)
    }
}