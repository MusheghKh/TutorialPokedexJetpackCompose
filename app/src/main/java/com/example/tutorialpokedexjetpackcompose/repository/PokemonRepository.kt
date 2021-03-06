package com.example.tutorialpokedexjetpackcompose.repository

import com.example.tutorialpokedexjetpackcompose.data.remote.PokemonApi
import com.example.tutorialpokedexjetpackcompose.data.remote.responses.Pokemon
import com.example.tutorialpokedexjetpackcompose.data.remote.responses.PokemonList
import com.example.tutorialpokedexjetpackcompose.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokemonApi
) {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(name: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(name)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }
}