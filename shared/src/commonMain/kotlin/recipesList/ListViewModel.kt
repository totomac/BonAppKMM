package recipesList

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class ListViewModel : ViewModel() {

    val uiModel = MutableStateFlow<UiModel>(UiModel(listOf(Recipe("test", "test"))))
}

data class UiModel(val recipes: List<Recipe>)
data class Recipe(val title: String, val description: String)
