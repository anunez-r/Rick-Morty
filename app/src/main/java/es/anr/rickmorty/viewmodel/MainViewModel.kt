package es.anr.rickmorty.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.anr.rickmorty.model.Character
import es.anr.rickmorty.net.RetrofitInstance
import es.anr.rickmorty.ui.RickMortyPresenter
import es.anr.rickmorty.ui.RickMortyViewModel
import kotlinx.coroutines.launch
import retrofit2.awaitResponse
import java.lang.Exception

class MainViewModel : ViewModel(), RickMortyViewModel {

    private lateinit var activity: RickMortyPresenter
    private val apiService = RetrofitInstance.api

    val _characters: MutableLiveData<List<Character>> = MutableLiveData<List<Character>>()

    val characters: LiveData<List<Character>> = _characters

    fun fetchAllCharacters() {
        viewModelScope.launch {
            try {
                val response = apiService.getAllCharacters().awaitResponse().body()?.results
                if (response?.isNotEmpty()!!) {
                    response.forEach {
                        println(it.name)
                    }
                    _characters.value = response!!
                    showCharacters()
                }
            } catch (e:Exception) {
                e.printStackTrace()
            }
        }

    }

    override fun setContext(context: RickMortyPresenter) {
        this.activity = context
    }

    override fun showCharacters() {
        activity.showCharacters(_characters.value)
    }

}
