package recipesList

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class ListViewModel : ViewModel() {

    val repository = RecipesRepository()
    val uiModel = repository.observe().map { UiModel(it) }

}

data class UiModel(val recipes: List<Recipe>)
