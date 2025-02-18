package com.udemy.myrecipeapp.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.udemy.myrecipeapp.data.Category
import com.udemy.myrecipeapp.presentation.components.CategoryItem

@Composable
fun CategoriesScreen(categories: List<Category>, navigateToDetail: (Category) -> Unit) {
    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
        items(categories) { category ->
            CategoryItem(category = category, { navigateToDetail(category) })
        }
    }
}

@PreviewLightDark
@Composable
private fun CategoriesScreenPreview() {
    CategoriesScreen(
        categories = listOf(
            Category(
                "1",
                "Beef",
                "",
                "https://www.themealdb.com/images/category/beef.png"
            )
        ),
        {}
    )
}
