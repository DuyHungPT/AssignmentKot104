package com.example.assignmentkot104

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

class StartScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StartScreen {

                val intent = Intent(this, Sign_Up::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}

@Composable
fun StartScreen(onTimeout: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(3000)
        onTimeout()
    }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.backgroundchao),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "MAKE YOUR",
                style = TextStyle(
                    fontSize = 24.sp,
                    color = Color(0xFF000000)
                ),
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 50.dp, y = 240.dp),
            )
            Text(
                text = "HOME BEAUTIFUL",
                style = TextStyle(
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF070707)
                ),
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 50.dp, y = 280.dp),
            )
            Text(
                text = "The best simple place where you \ndiscover most wonderful furnitures\nand make your home beautiful",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0A0A0A),
                    lineHeight = 35.sp
                ),
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 50.dp, y = 350.dp)
                    .padding(horizontal = 17.dp),
                textAlign = TextAlign.Start
            )
            Button(
                onClick = { /* Hành động khi nhấn nút */ },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 156.dp)
                    .shadow(6.dp, RoundedCornerShape(10.dp))
                    .size(width = 159.dp, height = 54.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                Text("Get Started")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultStartScreen() {
    StartScreen {}
}
