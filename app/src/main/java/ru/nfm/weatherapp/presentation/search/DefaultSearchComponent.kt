package ru.nfm.weatherapp.presentation.search

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

class DefaultSearchComponent @Inject constructor(
    private val openReason: OpenReason,
    private val storeFactory: SearchStoreFactory,
    private val onBackClicked: () -> Unit,
    private val onCitySavedToFavorite: () -> Unit,
    private val onForecastForCityRequested: (City) -> Unit,
    componentContext: ComponentContext
) : SearchComponent, ComponentContext by componentContext {

    private val store = instanceKeeper.getStore { storeFactory.create(openReason) }
    private val scope = componentScope()

    init {
        scope.launch {
            store.labels.collect {
                when(it) {
                    SearchStore.Label.ClickBack -> {
                        onBackClicked()
                    }

                    is SearchStore.Label.OpenForecast -> {
                        onForecastForCityRequested(it.city)
                    }

                    SearchStore.Label.SavedToFavorite -> {
                        onCitySavedToFavorite()
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override val model: StateFlow<SearchStore.State> = store.stateFlow

    override fun changeSearchQuery(query: String) {
        store.accept(SearchStore.Intent.ChangeSearchQuery(query))
    }

    override fun clickBack() {
        store.accept(SearchStore.Intent.ClickBack)
    }

    override fun onClickSearch() {
        store.accept(SearchStore.Intent.ClickSearch)
    }

    override fun onClickCity(city: City) {
        store.accept(SearchStore.Intent.ClickCity(city))
    }
}