package com.android.articles.retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import util.MockResponseFileReader

@RunWith(JUnit4::class)
class ArticleAPITest {


    private val server = MockWebServer()
    private lateinit var repository: RetrofitRepository
    private lateinit var mockedResponse: String
    private val gson = GsonBuilder()
        .setLenient()
        .create()

    @Before
    fun init(){
        server.start(8000)
        val BASE_URL = server.url("/").toString()
        val okHttpClient = OkHttpClient
            .Builder()
            .build()
        val service = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build().create(ArticleAPI::class.java)
        repository = RetrofitRepository(service)
    }
    @Test
    fun testApiSuccess(){
        mockedResponse = MockResponseFileReader("FakeArticles.json").content

        server.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(mockedResponse)
        )
        val expectedResponse = Gson().fromJson(mockedResponse,ArticleResponse::class.java)
        println("result!!.body()")
        val result:  Response<ArticleResponse>? = runBlocking{ repository.Api.getArticles().execute() }

        Assert.assertNotNull(result)
        result?.let {
            Assert.assertTrue(result.body() == expectedResponse)
        }

    }
    @Test
    fun testApi404() {

        server.enqueue(
            MockResponse()
                .setResponseCode(404)
                .setBody("Client Error")
        )
        val response = runBlocking { repository.Api.getArticles().execute() }
        Assert.assertNotNull(response)
        Assert.assertTrue(response.message().equals("Client Error"))
        Assert.assertTrue(response.code()==404)
    }
    @Test
    fun testApi500() {
        server.enqueue(
            MockResponse()
                .setResponseCode(500)
                .setBody("Server Error")
        )
        val response = runBlocking { repository.Api.getArticles().execute() }
        Assert.assertNotNull(response)
        Assert.assertTrue(response.message().equals("Server Error"))
        Assert.assertTrue(response.code()==500)
    }
    @After
    fun tearDown() {
        server.shutdown()
    }
}