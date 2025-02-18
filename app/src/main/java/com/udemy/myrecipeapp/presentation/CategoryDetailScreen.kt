package com.udemy.myrecipeapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.udemy.myrecipeapp.data.Category

@Composable
fun CategoryDetailScreen(modifier: Modifier = Modifier, category: Category) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            category.name,
            color = Color.Black,
            style = TextStyle(fontWeight = FontWeight.Bold),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Image(
            painter = rememberAsyncImagePainter(category.imageUrl),
            contentDescription = "${category.name} thumb",
            modifier = Modifier
                .aspectRatio(1f),
        )

        Text(
            category.description,
            color = Color.Black,
            style = TextStyle(fontWeight = FontWeight.Bold),
            textAlign = TextAlign.Justify,
            modifier = Modifier.verticalScroll(rememberScrollState())
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun CategoryDetailScreenPreview() {
    CategoryDetailScreen(
        modifier = Modifier.background(MaterialTheme.colorScheme.background),
        Category(
            "1",
            "Beef",
            "Beef description",
            "https://www.themealdb.com/images/category/beef.png"
        ),
    )
}
