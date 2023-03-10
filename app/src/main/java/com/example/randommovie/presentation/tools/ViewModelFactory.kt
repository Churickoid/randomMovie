package com.example.randommovie.presentation.tools

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.randommovie.presentation.App
import com.example.randommovie.presentation.screen.filter.FilterViewModel
import com.example.randommovie.presentation.screen.info.InfoViewModel
import com.example.randommovie.presentation.screen.movie.MovieViewModel

class ViewModelFactory(private val app: App) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModel = when (modelClass) {
            MovieViewModel::class.java -> {
                MovieViewModel(app.container.getRandomMovieUseCase,
                    app.container.getSearchFilterUseCase,
                    )
            }
            FilterViewModel::class.java -> {
                FilterViewModel(app.container.setSearchFilterUseCase,
                    app.container.getGenresUseCase,
                    app.container.getCountriesUseCase
                    )
            }
            InfoViewModel::class.java -> {
                InfoViewModel(app.container.getMoreInformationUseCase)
            }
            else -> {
                throw Exception("Unknown View model class")
            }

        }

        return viewModel as T
    }
}
fun Fragment.factory() = ViewModelFactory(requireContext().applicationContext as App)
