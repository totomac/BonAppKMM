import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import org.jetbrains.compose.resources.ExperimentalResourceApi
import recipesList.ListViewModel
import recipesList.UiModel

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    MaterialTheme {
        val listViewModel = getViewModel(Unit, viewModelFactory { ListViewModel() })
        RecipesPage(listViewModel)
    }
}

@Composable
fun RecipesPage(viewModel: ListViewModel) {
    val uiModel by viewModel.uiModel.collectAsState(initial = UiModel(emptyList()))
    LazyColumn {
        items(uiModel.recipes) {
            Text(it.title)
            Text(it.description)
        }
    }

}

expect fun getPlatformName(): String
