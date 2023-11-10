package com.example.gameofthrones.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitAPI {

    /**
     * Responsavel por definir a URL onde vou buscar os dados e por definir o converter utilizado
     * apos a configuracao acima retorna um objeto do tipo retrofit, configurado para o projeto.
     **/
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://https://thronesapi.com/")
            .addConverterFactory((GsonConverterFactory.create()))
            .build()
    }
}