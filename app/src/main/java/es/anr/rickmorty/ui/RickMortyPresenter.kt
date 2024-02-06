package es.anr.rickmorty.ui

import es.anr.rickmorty.model.Character

interface RickMortyPresenter {

    fun fetchCharacters()

    fun showCharacters(characters: List<Character>?)

}