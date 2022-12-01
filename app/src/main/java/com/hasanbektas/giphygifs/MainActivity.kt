package com.hasanbektas.giphygifs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hasanbektas.giphygifs.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.recycler_row.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val BASE_URL = "https://api.giphy.com/"
    private val API_KEY = "VNaBgvICOOucKOKIANiaQB7ZUEkGt2wr"

    private lateinit var dataList : ArrayList<GifDataModel>

    private lateinit var gifrecAdapter : GifRecAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData("trend")

        binding.searchButton.setOnClickListener {

            dataList.clear()

            var term = binding.searchText.text.toString()

            loadData(term)
        }

        dataList = ArrayList<GifDataModel>()

        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(this,2)
         recyclerView.layoutManager = layoutManager
    }
    private fun loadData(s: String){

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(GifAPI::class.java)

        val call = service.getData(API_KEY,s)

        call.enqueue(object : Callback<GifModel>{
            override fun onResponse(call: Call<GifModel>, response: Response<GifModel>) {

                if (response.isSuccessful) {

                    response.body()?.let {

                        dataList = ArrayList(it.data)

                        dataList?.let {

                            gifrecAdapter = GifRecAdapter(this@MainActivity,dataList)
                            recyclerView.adapter = gifrecAdapter
                        }
                    }
                }
            }
            override fun onFailure(call: Call<GifModel>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}