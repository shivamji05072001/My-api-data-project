package com.example.shivamandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apidata.Apiinterface
import com.example.apidata.Users
import com.example.apidata.userrecycle
import com.example.shivamandroid.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val base_url="https://my-json-server.typicode.com/"
class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: userrecycle
    lateinit var toolbar:androidx.appcompat.widget.Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar=findViewById(R.id.toolbar)

        recyclerView=findViewById(R.id.recyclerview)
        recyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        getMydata()

        toolbar.setNavigationOnClickListener{
            finishAffinity()
        }
    }

    private fun getMydata() {
       val retrofitBuilder=Retrofit.Builder()
           .addConverterFactory(MoshiConverterFactory.create())
           .baseUrl(base_url)
           .build()
           .create(Apiinterface::class.java)
        val retrofitData=retrofitBuilder.getdata()
        retrofitData.enqueue(object : Callback<List<Users.UsersItem>?> {
            override fun onResponse(call: Call<List<Users.UsersItem>?>, response: Response<List<Users.UsersItem>?>) {
                val responseBody = response.body()!!
                adapter= userrecycle(baseContext,responseBody)
                adapter.notifyDataSetChanged()
                recyclerView.adapter=adapter

            }

            override fun onFailure(call: Call<List<Users.UsersItem>?>, t: Throwable) {
             d("MainActivity","onFailure"+t.message)
            }
        })
    }
}