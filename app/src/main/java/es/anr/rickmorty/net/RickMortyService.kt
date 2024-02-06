package es.anr.rickmorty.net

import es.anr.rickmorty.model.AllCharacters
import es.anr.rickmorty.model.Character
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RickMortyService {

    @GET("character/")
//    suspend
    fun getAllCharacters():Call<AllCharacters>

    @GET("character/{id}")
    fun getCharacterById(@Path("id") id:Int):Call<Character>

}