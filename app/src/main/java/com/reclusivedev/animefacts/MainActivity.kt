package com.reclusivedev.animefacts

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.reclusivedev.animefacts.adapters.AnimeAdapter
import com.reclusivedev.animefacts.interfaces.ApiInterface
import com.reclusivedev.animefacts.models.AnimeList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://anime-facts-rest-api.herokuapp.com/"

class MainActivity : AppCompatActivity() {
    private lateinit var animeRV: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        animeRV = findViewById(R.id.animeRV)

        getAnime()
    }

    private fun getAnime() {
        val retroInstance = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retroData = retroInstance.getAnimeList()

        retroData.enqueue(object : Callback<AnimeList?> {
            override fun onResponse(call: Call<AnimeList?>, response: Response<AnimeList?>) {

                val responseBody = response.body()!!
                responseBody.let {
                    val adapter = AnimeAdapter(this@MainActivity, responseBody.data)


                    animeRV.layoutManager =
                        StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

                    animeRV.adapter = adapter
                }
            }

            override fun onFailure(call: Call<AnimeList?>, t: Throwable) {
                Log.d("TAG", "onFailure: " + t.message)
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}