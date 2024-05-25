package com.example.assignmentkot104

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Home : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

                HomeScreen()

        }
    }
}



@Composable
fun HomeScreen() {
    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.search), // Thay thế bằng id hình ảnh thực tế của bạn
                contentDescription = "Image 1",
                modifier = Modifier.size(25.dp)
            )
            Column {
                Text(
                    text = "MAKE HOME",

                    modifier = Modifier.padding(horizontal = 20.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Text(
                    text = "BEAUTYFUL",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    ),

                    modifier = Modifier.padding(horizontal = 20.dp)

                )
            }

            Image(
                painter = painterResource(id = R.drawable.bi_cart2), // Thay thế bằng id hình ảnh thực tế của bạn
                contentDescription = "Image 2",
                modifier = Modifier.size(25.dp)
            )
        }


        Spacer(modifier = Modifier.height(16.dp))
        HorizontalImageListt(
            images = listOf(
                R.drawable.star,
                R.drawable.chairr,
                R.drawable.bed,
                R.drawable.table,
                R.drawable.sofa,
                R.drawable.star,
                R.drawable.chairr,
                R.drawable.bed,
                R.drawable.table,
                R.drawable.sofa
            ),
            descriptions = listOf(
                "Star",
                "Chair",
                "Bed",
                "Table",
                "Sofa",
                "Star",
                "Chair",
                "Bed",
                "Table",
                "Sofa"
            )
        )
    }
}
@Composable
fun HorizontalImageListt(images: List<Int>, descriptions: List<String>) {
    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .padding(vertical = 16.dp)
    ) {
        images.zip(descriptions).forEach { (imageRes, description) ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .size(64.dp)
                        .padding(bottom = 8.dp)
                        .background(
                            color = Color.Cyan,
                            shape = RoundedCornerShape(10.dp)
                        )
                )
                Text(
                    text = description,
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    ),
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {

        HomeScreen()

}
