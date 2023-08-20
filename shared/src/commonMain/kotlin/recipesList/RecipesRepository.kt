package recipesList

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.firestore
import dev.gitlive.firebase.initialize
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RecipesRepository {

    fun observe(): Flow<List<Recipe>> {
        return Firebase.firestore.collection("recipes").snapshots.map {
            it.documents.map {
                Recipe(it.get("title"), it.get("description"))
            }
        }
    }
}

data class Recipe(val title: String, val description: String)
