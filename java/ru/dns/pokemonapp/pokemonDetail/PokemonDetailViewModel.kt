package ru.dns.pokemonapp.pokemonDetail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.dns.pokemonapp.data.remote.responses.Pokemon
import ru.dns.pokemonapp.repository.PokemonRepository
import ru.dns.pokemonapp.util.Resource
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {
    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
    }
}