package ru.dns.pokemonapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.dns.pokemonapp.data.remote.responses.Pokemon
import ru.dns.pokemonapp.data.remote.responses.PokemonList
import ru.dns.pokemonapp.data.remote.responses.PokemonListItem

interface PokeApi {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): PokemonList

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name: String
    ): Pokemon
}