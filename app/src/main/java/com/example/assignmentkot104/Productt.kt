package com.example.assignmentkot104

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Productt : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductScreen()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductScreen() {
    var selectedColor by remember { mutableStateOf(0) }
    var quantity by remember { mutableStateOf(1) }

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(420.dp)
                    .background(Color.LightGray, RoundedCornerShape(16.dp))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.imgproduct),
                    contentDescription = "Product Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                IconButton(
                    onClick = { /* TODO: Handle back navigation */ },
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(16.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.frame),
                        contentDescription = "Back",
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                            .background(Color.White.copy(alpha = 0.7f))
                    )
                }
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(16.dp)
                ) {
                    ColorOption(
                        color = Color.Green,
                        isSelected = selectedColor == 0,
                        onClick = { selectedColor = 0 }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    ColorOption(
                        color = Color.Green,
                        isSelected = selectedColor == 1,
                        onClick = { selectedColor = 1 }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    ColorOption(
                        color = Color(0xFFFFC107),
                        isSelected = selectedColor == 2,
                        onClick = { selectedColor = 2 }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Minimal Stand", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))

            // Row for price and quantity controls
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "$50",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFF5722),
                    modifier = Modifier.weight(1f)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { if (quantity > 1) quantity -= 1 }) {
                        Icon(
                            painter = painterResource(id = R.drawable.img_1),
                            modifier = Modifier
                                .width(20.dp)

                                .height(20.dp),
                            contentDescription = "Decrease Quantity"
                        )
                    }
                    Text(text = "$quantity", fontSize = 26.sp, fontWeight = FontWeight.Bold)
                    IconButton(onClick = { quantity += 1 }) {
                        Icon(
                            painter = painterResource(id = R.drawable.img),
                            modifier = Modifier
                                .width(25.dp)
                                .height(25.dp),
                            contentDescription = "Increase Quantity"
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "Rating",
                    tint = Color(0xFFFFC107)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "4.5", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "(50 reviews)", fontSize = 14.sp, color = Color.Gray)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Minimal Stand is made of natural wood. The design is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home.",
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(26.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(10.dp)
            ) {


                Icon(
                    painter = painterResource(id = R.drawable.mark),
                    contentDescription = null,
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)


                )
                Button(
                    onClick = { /* TODO: Handle add to cart */ },
                    modifier = Modifier
                        .weight(3f)
                        .height(50.dp)
                        .padding(end = 4.dp)
                        .shadow(6.dp, RoundedCornerShape(8.dp))
                        .padding(start = 10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
                ) {
                    Text(text = "Add to cart", color = Color.White, fontSize = 16.sp)
                }

            }
        }
    }
}


@Composable
fun ColorOption(color: Color, isSelected: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .clickable(onClick = onClick)
            .padding(4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color, shape = CircleShape)
        )

        if (isSelected) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White.copy(alpha = 0.4f), shape = CircleShape)
                    .padding(4.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductScreenPreview() {
    ProductScreen()
}
