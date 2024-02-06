package es.anr.rickmorty.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://rickandmortyapi.com/api/"

// Instancia de Retrofit
object RetrofitInstance {
    val api: RickMortyService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(RickMortyService::class.java)
    }
}