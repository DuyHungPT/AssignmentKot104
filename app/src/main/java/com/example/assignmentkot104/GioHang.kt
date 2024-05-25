package com.example.assignmentkot104

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import java.text.DecimalFormat


data class CartItem(val id: Int, val name: String, val price: Double, var quantity: Int, val imageRes: Int)

class GioHang : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartPreview()
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ShoppingCartScreen(cartItems: List<CartItem>) {
    var total by remember { mutableStateOf(0.0) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = { /* Handle exit */ }) {
                            Icon(Icons.Default.KeyboardArrowLeft, contentDescription = "Exit")
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            "My cart",
                            modifier = Modifier.weight(8f),
                            textAlign = TextAlign.Center,
                            color = Color.Black
                        )
                        IconButton(onClick = { /* Handle exit */ }) {
                            Icon(Icons.Default.ArrowDropDown, contentDescription = "Exit",
                                modifier = Modifier
                                    .width(2.dp))
                        }
                        Spacer(modifier = Modifier.weight(1f))
                    }
                },
                backgroundColor = Color.White,
                contentColor = Color.Black
            )
        },

        ) {
        Column(modifier = Modifier.fillMaxSize()) {
            LazyColumn {
                items(cartItems) { item ->
                    ShoppingCartItem(item) { newItem ->
                        total += newItem.price * (newItem.quantity - item.quantity)
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 60.dp),

                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Total: ${DecimalFormat("#.##").format(total)}",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
                Text(
                    text = "$ 95$",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            }
            androidx.compose.material3.Button(
                onClick = {
                    // Xử lý sự kiện khi nhấp vào nút "Login"

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .height(60.dp)
                    .shadow(6.dp, RoundedCornerShape(10.dp))
                    .width(180.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                androidx.compose.material3.Text(
                    text = "Check Out",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.White
                    )
                )
            }
        }
    }
}

@Composable
fun ShoppingCartItem(item: CartItem, onQuantityChange: (CartItem) -> Unit) {
    var quantity by remember { mutableStateOf(item.quantity) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = item.imageRes),
            contentDescription = item.name,
            modifier = Modifier
                .size(150.dp)
                .padding(end = 16.dp),
            contentScale = ContentScale.Crop
        )


        Column(modifier = Modifier.weight(1f)) {

            Text(item.name)
            Text("$${item.price}")


            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                IconButton(onClick = {
                    if (quantity > 0) {
                        quantity--
                        onQuantityChange(item.copy(quantity = quantity))
                    }
                }) {
                    Icon(Icons.Default.Add, contentDescription = "Decrease quantity")
                }
                Text("$quantity", modifier = Modifier.padding(horizontal = 8.dp))
                IconButton(onClick = {
                    quantity++
                    onQuantityChange(item.copy(quantity = quantity))
                }) {
                    Icon(Icons.Default.Delete, contentDescription = "Increase quantity")
                }
            }
        }


        IconButton(onClick = { /* Handle item removal */ }) {
            Icon(Icons.Default.Close, contentDescription = "Remove item")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShoppingCartPreview() {
    val sampleCartItems = listOf(
        CartItem(1, "Minimal Stand", 25.00, 1, R.drawable.table1),
        CartItem(2, "Coffee Table", 20.00, 1, R.drawable.lamp),
        CartItem(3, "Minimal Desk", 50.00, 1, R.drawable.chiar1)
    )
    ShoppingCartScreen(sampleCartItems)
}
