package ru.dns.pokemonapp.data.remote.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonList(
    @SerialName("count")
    val count: Int,

    @SerialName("next")
    val next: String,

    @SerialName("previous")
    val previous: String,

    @SerialName("results")
    val results: List<PokemonListItem>
)

@Serializable
data class PokemonListItem(
    @SerialName("name")
    val name: String,

    @SerialName("url")
    val url: String
)
