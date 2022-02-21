package com.example.infocovid_19.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.infocovid_19.R
import com.example.infocovid_19.api.RetrofitClient
import com.example.infocovid_19.model.IndonesiaResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showIndonesia()


        btnProvince.setOnClickListener{
            Intent(this@MainActivity, ProvinceActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    private fun showIndonesia(){
        RetrofitClient.instance.getIndonesia().enqueue(object : Callback<ArrayList<IndonesiaResponse>>{
            override fun onFailure(call: Call<ArrayList<IndonesiaResponse>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(
                call: Call<ArrayList<IndonesiaResponse>>,
                response: Response<ArrayList<IndonesiaResponse>>
            ) {
                val indonesia = response.body()?.get(0)
                val positive = indonesia?.positif
                val hospitalized = indonesia?.dirawat
                val recover = indonesia?.sembuh
                val death = indonesia?.meninggal

                val cassPositive : TextView = findViewById(R.id.tvPositive)
                cassPositive.text= positive
                val cassHospitalized :TextView = findViewById(R.id.tvHospitalized)
                cassHospitalized.text= hospitalized
                val cassRecover : TextView = findViewById(R.id.tvRecover)
                cassRecover.text= recover
                val cassDeath : TextView=findViewById(R.id.tvDeath)
                cassDeath.text=death


            }

        })

    }
}