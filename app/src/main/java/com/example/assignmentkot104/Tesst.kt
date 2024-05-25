package com.example.assignmentkot104

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.platform.LocalContext


class Tesst : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreenn()
        }
    }
}

@Composable
fun HomeScreenn() {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar() }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            CategoriesRow()
            PopularItemsList()
        }
    }
}

@Composable
fun TopBar() {
    TopAppBar(
        backgroundColor = Color.White,
        contentColor = Color.Black,
        elevation = 0.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { /* TODO */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "Search",
                    modifier = Modifier.size(24.dp)
                )
            }
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Make home",
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    )
                    Text(
                        text = "BEAUTIFUL",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    )
                }
            }
            IconButton(onClick = { /* TODO */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.bi_cart2),
                    contentDescription = "Cart",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Composable
fun CategoriesRow() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        items(listOf(
            Pair("Popular", R.drawable.bed),
            Pair("Chair", R.drawable.chair),
            Pair("Table", R.drawable.bi_cart2),
            Pair("Armchair", R.drawable.sofa),
            Pair("Bed", R.drawable.bed),
            Pair("Lamp", R.drawable.star)
        )) { item ->
            CategoryItem(item.first, item.second)
        }
    }
}

@Composable
fun CategoryItem(name: String, iconRes: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 10.dp)
    ) {
        Icon(painter = painterResource(id = iconRes), contentDescription = name, modifier = Modifier.size(44.dp).background(Color.Black.copy(alpha = 0.1f)).padding(6.dp))
        Text(text = name, fontSize = 12.sp)
    }
}

@Composable
fun PopularItemsList() {
    val items = listOf(
        Product("Black Simple Lamp", "$12.00", R.drawable.lamp),
        Product("Minimal Stand", "$25.00", R.drawable.table),
        Product("Coffee Chair", "$20.00", R.drawable.chiar1),
        Product("Simple Desk", "$50.00", R.drawable.table1),
        Product("Modern Sofa", "$150.00", R.drawable.lamp),
        Product("Elegant Bed", "$300.00", R.drawable.chiar1),
        Product("Stylish Table", "$45.00", R.drawable.table),
        Product("Classic Lamp", "$18.00", R.drawable.table)
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(10.dp),
        contentPadding = PaddingValues(10.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(items) { item ->
            PopularItemCard(item)
        }
    }
}

@Composable
fun PopularItemCard(item: Product) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                )
                Image(
                    painter = painterResource(id = item.imageRes),
                    contentDescription = item.name,
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Icon(
                    painter = painterResource(id = R.drawable.bi_cart2),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .size(46.dp)
                        .padding(7.dp)
                        .align(Alignment.BottomEnd)
                        .shadow(6.dp, RoundedCornerShape(10.dp))
                        .background(Color.Gray.copy(alpha = 0.5f))
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = item.name,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Text(
                text = item.price,
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
    }
}

data class Product(
    val name: String,
    val price: String,
    val imageRes: Int
)

@Composable
fun BottomNavigationBar() {
    val context = LocalContext.current
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Gray
    ) {
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "Home",
                    modifier = Modifier.size(30.dp)
                )
            },
            selected = true,
            onClick = {
                val intent = Intent(context, Success::class.java)
                context.startActivity(intent)
            }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.mark),
                    contentDescription = "Favorites",
                    modifier = Modifier.size(30.dp)
                )
            },
            selected = false,
            onClick = {

                val intent = Intent(context, Productt::class.java)
                context.startActivity(intent)
            }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.bell),
                    contentDescription = "Notifications",
                    modifier = Modifier.size(30.dp)
                )
            },
            selected = false,
            onClick = {
                val intent = Intent(context, GioHang::class.java)
                context.startActivity(intent) }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.human),
                    contentDescription = "Profile",
                    modifier = Modifier.size(30.dp)
                )
            },
            selected = false,
            onClick = {
                val intent = Intent(context, CheckOut::class.java)
                context.startActivity(intent)
            }

        )
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPrevieww() {
    HomeScreenn()
}
