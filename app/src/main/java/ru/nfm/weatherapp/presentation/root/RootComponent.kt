package ru.nfm.weatherapp.presentation.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import ru.nfm.weatherapp.presentation.details.DetailsComponent
import ru.nfm.weatherapp.presentation.favorite.FavoriteComponent
import ru.nfm.weatherapp.presentation.search.SearchComponent

interface RootComponent {

    val stack: Value<ChildStack<*, Child>>

    sealed interface Child {

        data class Favorite(val component: FavoriteComponent) : Child

        data class Search(val component: SearchComponent) : Child

        data class Details(val component: DetailsComponent) : Child
    }
}