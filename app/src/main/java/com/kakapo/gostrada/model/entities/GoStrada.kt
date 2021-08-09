package com.kakapo.gostrada.model.entities

import com.google.gson.annotations.SerializedName

data class GoStrada(
    @SerializedName("error") var error: String,
    @SerializedName("error_msg") var errorMsg: String
){
    data class msg(
        @SerializedName("id") var id: Int?,
        @SerializedName("name") var name: String?,
        @SerializedName("username") var username: String,
        @SerializedName("password") var password: String
    )
}


