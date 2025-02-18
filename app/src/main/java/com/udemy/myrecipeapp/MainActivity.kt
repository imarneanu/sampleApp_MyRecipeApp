package com.udemy.myrecipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.udemy.myrecipeapp.data.Category
import com.udemy.myrecipeapp.presentation.CategoryDetailScreen
import com.udemy.myrecipeapp.presentation.MainViewModel
import com.udemy.myrecipeapp.presentation.RecipeScreen
import com.udemy.myrecipeapp.ui.theme.MyRecipeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyRecipeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RecipeApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun RecipeApp(modifier: Modifier = Modifier) {
    val recipeViewModel: MainViewModel = viewModel()
    val viewState by recipeViewModel.categoriesState

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route) {
        composable(route = Screen.RecipeScreen.route) {
            RecipeScreen(modifier, viewState = viewState, navigateToDetail = { category ->
                println("RecipeApp - RecipeScreen $category")

                navController.currentBackStackEntry?.savedStateHandle?.set("category", category)
                navController.navigate(Screen.CategoryDetailScreen.route)
            })
        }
        composable(route = Screen.CategoryDetailScreen.route) {
            val category: Category =
                navController.previousBackStackEntry?.savedStateHandle?.get<Category>("category")
                    ?: Category("", "", "", "")
            println(category)
            CategoryDetailScreen(modifier = modifier, category = category)
        }
    }
}
