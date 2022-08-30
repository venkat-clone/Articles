package com.android.articles.retrofit

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class RetrofitRepository
@Inject constructor(val Api: ArticleAPI){
    val retrofit:Retrofit = RetrofitServices.CreateRetrofitServices()


    fun getArticles(data:MutableLiveData<List<ArticleEntity>>,code:MutableLiveData<Int>) {
        Api.getArticles().enqueue(object : Callback<ArticleResponse> {
            override fun onResponse(
                call: Call<ArticleResponse>,
                response: Response<ArticleResponse>
            ) {
                if (!response.isSuccessful){
                    Log.e("Error ","Response is Not Successful," +
                            " Response Code ${response.code()}\n" +
                            "$response")
                    code.postValue(1)
                }else if(response.body()==null){
                    Log.e("Error ","Response Body is null" +
                            " Response Code ${response.code()}\n" +
                            "$response")
                    code.postValue(1)
                }
                else{
                    code.postValue(2)
                    data.postValue(response.body()!!.results)
                }
            }
            override fun onFailure(call: Call<ArticleResponse>, t: Throwable) {
                Log.e("Error ","Filed to fetch Data with the error ${t.message}")
                code.postValue(-1)
                t.printStackTrace()
            }

        })
    }


}