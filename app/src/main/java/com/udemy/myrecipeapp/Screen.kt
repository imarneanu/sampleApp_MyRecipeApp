package com.udemy.myrecipeapp

sealed class Screen(val route: String) {
    data object RecipeScreen : Screen("recipeScreen")
    data object CategoryDetailScreen : Screen("detailScreen")
}
