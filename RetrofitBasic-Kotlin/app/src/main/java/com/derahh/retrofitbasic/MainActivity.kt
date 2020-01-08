package com.derahh.retrofitbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import com.derahh.retrofitbasic.adapter.UserAdapter
import com.derahh.retrofitbasic.model.User
import com.derahh.retrofitbasic.service.APIService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(APIService::class.java)

        api.fetchAllUsers().enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                d("dedi", "onFailure")
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                showData(response.body()!!)
                d("dedi", "onResponse: ${response.body()!![0].phone}")
            }

        })

        val users = mutableListOf<User>()
        for(i in 0..100) {
            users.add(User("Dedi", "Rahmansah", "dedir2@gmail.com", "081299439698"))
        }
    }

    private fun showData(users: List<User>) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = UserAdapter(users)
        }
    }
}
