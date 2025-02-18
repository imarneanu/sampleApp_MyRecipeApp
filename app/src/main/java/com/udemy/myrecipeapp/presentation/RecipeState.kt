package com.udemy.myrecipeapp.presentation

import androidx.compose.runtime.Immutable
import com.udemy.myrecipeapp.data.Category

@Immutable
data class RecipeState(
    val loading: Boolean = true,
    val list: List<Category> = emptyList(),
    val error: String? = null,
)
