package ru.nfm.weatherapp.presentation.root

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import ru.nfm.weatherapp.presentation.details.DetailsContent
import ru.nfm.weatherapp.presentation.favorite.FavoriteContent
import ru.nfm.weatherapp.presentation.search.SearchContent
import ru.nfm.weatherapp.presentation.ui.theme.WeatherAppTheme

@Composable
fun RootContent(component: RootComponent) {

    WeatherAppTheme {
        Children(stack = component.stack) {
            when (val instance = it.instance) {
                is RootComponent.Child.Details -> {
                    DetailsContent(component = instance.component)
                }

                is RootComponent.Child.Favorite -> {
                    FavoriteContent(component = instance.component)
                }

                is RootComponent.Child.Search -> {
                    SearchContent(component = instance.component)
                }
            }
        }
    }
}