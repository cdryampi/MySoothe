package com.ircarren.mysoothe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ircarren.mysoothe.models.CategoryItem
import com.ircarren.mysoothe.models.RegionItem
import com.ircarren.mysoothe.providers.CategoryItemProvider
import com.ircarren.mysoothe.providers.IconProvider
import com.ircarren.mysoothe.providers.RegionesItemProvider
import com.ircarren.mysoothe.ui.theme.MySootheTheme




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySootheTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colorScheme.secondary) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        SearchBar()
                        Spacer(modifier = Modifier.height(8.dp))
                        CategoriesList()
                        Spacer(modifier = Modifier.height(8.dp))
                        RegionesList()
                        Spacer(modifier = Modifier.height(8.dp))
                        SootheNavBar()

                    }


                }
            }
        }
    }
}

// barra de busqueda
@Composable
fun SearchBar(modifier: Modifier = Modifier){
    Row(modifier = modifier.padding(8.dp)) {
        TextField(
            value = "",
            onValueChange = {},
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search,
                    contentDescription = null)
            },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.secondary,
                cursorColor = MaterialTheme.colorScheme.primary,
            ),
            placeholder = {
                Text(text = "Search")
            },
            modifier = modifier
                .heightIn(min = 56.dp)
                .fillMaxWidth()
        )
    }

}


// lista de categorias
@Composable
fun CategoriesList(modifier: Modifier = Modifier){
    Column(modifier=modifier) {
        Text(text = "Browse by category".uppercase(),
            style = MaterialTheme.typography.titleLarge,
            modifier = modifier.padding(8.dp))
        LazyRow(modifier = Modifier.padding(8.dp)){
            items(CategoryItemProvider.categories_items.size){
                CategoryItem(categoryItem = CategoryItemProvider.categories_items[it])
            }
        }
    }


}


@Composable
fun CategoryItem(modifier: Modifier = Modifier, categoryItem: CategoryItem){
    Column(modifier= modifier.padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally){
        // imagen
        Image(
            painter = painterResource(
                id = categoryItem.image,
                )
            ,contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        // descripcion
        Text(
            text = categoryItem.title,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )
    }
}

// lista de colecciones
@Composable
fun RegionesList(modifier: Modifier = Modifier){
    Column(modifier=modifier) {
        Text(text = "Favorite countries".uppercase(),
            style = MaterialTheme.typography.titleLarge,
            modifier = modifier.padding(8.dp))

        LazyHorizontalGrid(
            rows = GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier.height(120.dp)){
            items(RegionesItemProvider.regiones.size){
                RegionItemContainer(regionItem = RegionesItemProvider.regiones[it])
            }
        }
    }

}

@Composable
fun RegionItemContainer(modifier: Modifier = Modifier, regionItem: RegionItem){

    Surface(modifier = modifier, shape = MaterialTheme.shapes.small) {

        Row(modifier= modifier.width(192.dp), verticalAlignment = Alignment.CenterVertically){
            // imagen
            Image(
                painter = painterResource(
                    id = regionItem.image,
                )
                ,contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .size(56.dp)
            )
            // descripcion
            Text(
                text = regionItem.region,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .paddingFromBaseline(top = 24.dp, bottom = 8.dp)
                    .padding(8.dp)
            )
        }
    }


}

// Navigation bar Bottom
@Composable
fun BottomNavigation(modifier: Modifier = Modifier){
    var selectedItem by remember { mutableStateOf(0) }
    val items = IconProvider.icons

    Row(modifier= modifier,  verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.Center) {
        NavigationBar {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    icon = { Icon(item.icon, contentDescription = item.title) },
                    label = { Text(item.title) },
                    selected = selectedItem == index,
                    onClick = { selectedItem = index }
                )
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SootheNavBar() {
    MySootheTheme {
        Scaffold(
            bottomBar = { BottomNavigation() }
        ){
            padding-> HomeScreen(Modifier.padding(padding))
        }
    }
}

@Composable
fun HomeScreen(padding: Modifier) {
    Surface(color = MaterialTheme.colorScheme.secondary, modifier = Modifier.fillMaxSize()) {
        Column(verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.End){
            Text(text = "Designed by Yampi", style = MaterialTheme.typography.titleMedium, modifier = padding)
        }
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MySootheTheme {
        SearchBar()
    }
}

