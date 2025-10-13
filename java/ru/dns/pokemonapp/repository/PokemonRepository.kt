package ru.dns.pokemonapp.repository

import dagger.hilt.android.scopes.ActivityScoped
import ru.dns.pokemonapp.data.remote.PokeApi
import ru.dns.pokemonapp.data.remote.responses.Pokemon
import ru.dns.pokemonapp.data.remote.responses.PokemonList
import ru.dns.pokemonapp.data.remote.responses.PokemonListItem
import ru.dns.pokemonapp.util.Resource
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(offset, limit)
        } catch (e: Exception) {
            return Resource.Error(e.message.toString())
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }
}