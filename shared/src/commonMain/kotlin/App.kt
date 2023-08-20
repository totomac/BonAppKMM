import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
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
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = it.title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
            Text(it.description)
            Divider()
        }
    }

}

expect fun getPlatformName(): String
