package com.example.recycleradapterr

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.recycleradapterr.Model.Article
import com.example.recycleradapterr.Model.NewsData
import com.example.recycleradapterr.Retrofit.API
import com.example.recycleradapterr.Retrofit.RetrofitInstance
import com.example.recycleradapterr.databinding.ActivityMainBinding
import com.example.recycleradapterr.databinding.AdditemsBinding
import com.example.recyclerview.Adapter.RecyclerAdapter
import com.example.recyclerview.Model.RecyclerModel
import okhttp3.ResponseBody
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var recyclerAdapter: RecyclerAdapter
    var list = ArrayList<RecyclerModel>()
    var recyclerModel = RecyclerModel()
    private var newsData = ArrayList<Article>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        getNews()
    }

    private fun getNews() {
        RetrofitInstance.retrofitInstance().create(API::class.java).getData()
            .enqueue(object : Callback<ResponseBody?> {
                override fun onResponse(
                    call: Call<ResponseBody?>,
                    response: Response<ResponseBody?>
                ) {
                    val res = response.body()?.string()
                    val jsonObject = JSONObject().getJSONObject(res)
                    for (i in res!!.indices) {
                        val jsonArray = JSONArray(jsonObject).getJSONArray(i)
                        val title = jsonArray.getJSONObject(i).getString("title")
                        Log.d("TAG---->", title)
//                        news.content = jsonArray.getJSONObject(i).getJSONObject("images").getString("original")
//                        news.urlToImage = jsonArray.getJSONObject(i).getString("snippet")

                    }

                }

                override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                    Log.d("TAG---->", t.message.toString())
                }
            })
//            .enqueue(object : Callback<okhttp3.ResponseBody?> {
//                override fun onResponse(call: Call<NewsData?>, response: Response<NewsData?>) {
//                    val res = response.body()
//                    val dataSize = res!!.articles
//                    Log.d("TAG---->", res.articles.size.toString())
//                    for (i in dataSize.indices) {
//                        val news = Article()
//                        Log.d("TAG---->",res.articles[i].content)
//                        if (res.articles[i].urlToImage != null){
//
//                            news.title = res.articles[i].title
//                            news.content = res.articles[i].content
//                            news.urlToImage = res.articles[i].urlToImage
//                        }else{
//                            Log.d("TAG---->",res.articles[i].content)
//                            news.title = res.articles[i].title
//                            news.content = res.articles[i].content
//                            news.urlToImage = ""
//                        }
//                        newsData.add(news)
//                    }
//                    recyclerAdapter = RecyclerAdapter(newsData, this@MainActivity)
//                    binding.recyclerView.adapter = recyclerAdapter
//
//                }
//
//                override fun onFailure(call: Call<NewsData?>, t: Throwable) {
//
//                }
//
//            })
    }
}