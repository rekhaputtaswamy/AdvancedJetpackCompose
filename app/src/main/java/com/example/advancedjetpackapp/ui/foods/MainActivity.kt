package com.example.advancedjetpackapp.ui.foods

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.advancedjetpackapp.model.response.FoodResponse
import com.example.advancedjetpackapp.ui.theme.AdvancedJetpackAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdvancedJetpackAppTheme {
                FoodCategoriesScreen()
            }
        }
    }
}

@Composable
fun FoodCategoriesScreen() {
    val viewModel: FoodCategoriesViewModel = viewModel()
    val foods = viewModel.foodsState.value
    Scaffold(topBar = {
        AppBar(
            title = "Food Categories",
            icon = Icons.Default.Home
        ) {
            //Do Nothing
        }
    }) {
        LazyColumn(contentPadding = PaddingValues(16.dp)) {
            items(foods) { food ->
                FoodCategory(food)
            }
        }
    }
}

@Composable
fun AppBar(title: String, icon: ImageVector, iconClickAction: () -> Unit) {
    TopAppBar(
        navigationIcon = {
            Icon(
                icon,
                contentDescription = "",
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .clickable(onClick = { iconClickAction.invoke() })
            )
        },
        title = { Text(title) }
    )
}

@Composable
fun FoodCategory(food: FoodResponse) {
    Card(shape = RoundedCornerShape(8.dp),
         elevation = 2.dp,
         modifier = Modifier
             .fillMaxWidth()
             .padding(top = 16.dp)) {
        Row {
           Image(
               painter = rememberImagePainter(food.imageUrl),
               contentDescription = null,
               modifier = Modifier
                   .size(88.dp)
                   .padding(4.dp)
           )
           
            Column(modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(16.dp)) {
                Text(text = food.name, style = MaterialTheme.typography.h6)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AdvancedJetpackAppTheme {
        FoodCategoriesScreen()
    }
}