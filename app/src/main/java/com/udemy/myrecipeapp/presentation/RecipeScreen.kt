package com.udemy.myrecipeapp.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.udemy.myrecipeapp.data.Category

@Composable
fun RecipeScreen(
    modifier: Modifier = Modifier,
    viewState: RecipeState,
    navigateToDetail: (Category) -> Unit
) {
    Box(modifier = modifier.fillMaxSize()) {
        when {
            viewState.loading -> {
                CircularProgressIndicator(modifier = modifier.align(Alignment.Center))
            }

            viewState.error != null -> {
                Text(text = "ERROR OCCURRED", modifier = modifier.align(Alignment.Center))
            }

            else -> {
                CategoriesScreen(categories = viewState.list, { navigateToDetail(it) })
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun RecipeScreenPreview() {
    RecipeScreen(viewState = RecipeState(), navigateToDetail = {})
}
