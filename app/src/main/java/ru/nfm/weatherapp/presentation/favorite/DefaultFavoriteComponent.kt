package ru.nfm.weatherapp.presentation.favorite

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.nfm.weatherapp.domain.entity.City
import ru.nfm.weatherapp.presentation.extensions.componentScope
import javax.inject.Inject

class DefaultFavoriteComponent @Inject constructor(
    private val storeFactory: FavoriteStoreFactory,
    private val onCityItemClicked: (City) -> Unit,
    private val onAddFavoriteClicked: () -> Unit,
    private val onSearchClicked: () -> Unit,
    componentContext: ComponentContext
) : FavoriteComponent, ComponentContext by componentContext {

    private val store = instanceKeeper.getStore { storeFactory.create() }
    private val scope = componentScope()

    init {
        scope.launch {
            store.labels.collect {
                when(it) {
                    is FavoriteStore.Label.CityItemClicked -> {
                        onCityItemClicked(it.city)
                    }

                    FavoriteStore.Label.ClickAddToFavorite -> {
                        onAddFavoriteClicked()
                    }

                    FavoriteStore.Label.ClickSearch -> {
                        onSearchClicked()
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override val model: StateFlow<FavoriteStore.State> = store.stateFlow

    override fun onClickSearch() {
        store.accept(FavoriteStore.Intent.ClickSearch)
    }

    override fun onClickAddFavorite() {
        store.accept(FavoriteStore.Intent.ClickAddToFavorite)
    }

    override fun onCityItemClick(city: City) {
        store.accept(FavoriteStore.Intent.CityItemClicked(city))
    }
}