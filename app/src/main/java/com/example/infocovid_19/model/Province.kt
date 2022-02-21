package com.example.infocovid_19.model

import com.google.gson.annotations.SerializedName

data class Province(
    @SerializedName("Kode Provi")
    val code: Int,
    @SerializedName("Provinsi")
    val Province: String,
    @SerializedName("Kasus Posi")
    val positive: Int,
    @SerializedName("Kasus Semb")
    val recover:Int,
    @SerializedName("Kausu Mening")
    val death: Int

)