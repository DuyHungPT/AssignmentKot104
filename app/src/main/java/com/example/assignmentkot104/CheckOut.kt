package com.example.assignmentkot104

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

class CheckOut : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CheckoutScreen()
        }
    }
}

@Composable
fun ShippingAddressSection(namee: String, addresss: String) {
    Column {
        SectionTitle("Shipping Address")
        EditableInfoCard(
            title = namee,
            addresss = addresss
        )
    }
}


@Composable
fun CustomShippingAddress(namee: String, addresss: String) {
    ShippingAddressSection(namee, addresss)
}


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CheckoutScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Check out",
                            fontWeight = FontWeight.Bold
                        )
                    }

                },
                navigationIcon = {
                    IconButton(onClick = { /* TODO: Handle back navigation */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.frame),
                            contentDescription = "Back",
                            modifier = Modifier
                                .height(25.dp)
                                .width(25.dp)
                        )
                    }

                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Spacer(modifier = Modifier.height(70.dp))

            ShippingAddressSection(
                namee = "Bruno Fernandes",
                addresss = "25 rue Robert Latouche, Nice, 06200, Côte D'azur, France"
            )

            Spacer(modifier = Modifier.height(16.dp))

            SectionTitle("Payment")
            EditableInfoCard(
                title = "**** **** **** 3947",
                imageResId = R.drawable.card
            )

            Spacer(modifier = Modifier.height(16.dp))

            SectionTitle("Delivery method")
            EditableInfoCard(
                title = "DHL",
                imageResId = R.drawable.dhl
            )

            Spacer(modifier = Modifier.height(24.dp))

            OrderSummary()

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { /* TODO: Handle submit order */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .height(60.dp)
                    .shadow(6.dp, RoundedCornerShape(10.dp))
                    .width(180.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                Text(text = "SUBMIT ORDER")
            }
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        IconButton(onClick = { /* TODO: Handle edit */ }) {
            Icon(
                painter = painterResource(id = R.drawable.edit),
                contentDescription = "Edit"
            )
        }
    }
}

@Composable
fun EditableInfoCard(title: String, addresss: String? = null, imageResId: Int? = null) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .shadow(4.dp, RoundedCornerShape(8.dp))
            .background(Color.White.copy(alpha = 0.2f), RoundedCornerShape(8.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (imageResId != null) {
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = "",
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
            }

            Column {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                addresss?.let {
                    Text(
                        text = it,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}




@Composable
fun OrderSummary() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray.copy(alpha = 0.2f), RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        SummaryRow("Order:", "$95.00")
        SummaryRow("Delivery:", "$5.00")
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        SummaryRow("Total:", "$100.00", fontWeight = FontWeight.Bold)
    }
}

@Composable
fun SummaryRow(label: String, amount: String, fontWeight: FontWeight = FontWeight.Normal) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, fontSize = 16.sp)
        Text(text = amount, fontSize = 16.sp, fontWeight = fontWeight)
    }
}

@Preview(showBackground = true)
@Composable
fun CheckoutScreenPreview() {
    CheckoutScreen()
}
