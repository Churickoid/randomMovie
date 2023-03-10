package com.example.randommovie.domain.usecases.movie

import com.example.randommovie.domain.MovieRepository
import com.example.randommovie.domain.entity.Movie
import com.example.randommovie.domain.entity.SearchFilter

class GetRandomMovieUseCase(
    private val movieRepository: MovieRepository,
) {

    suspend operator fun invoke(searchFilter: SearchFilter): Movie {
        return movieRepository.getRandomMovie(searchFilter)
    }
}