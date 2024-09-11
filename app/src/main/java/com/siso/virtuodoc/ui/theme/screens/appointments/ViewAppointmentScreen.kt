package com.siso.virtuodoc.ui.theme.screens.appointments

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.siso.virtuodoc.R
import com.siso.virtuodoc.data.appointmentviewmodel
import com.siso.virtuodoc.model.Appointment

@Composable
fun ViewAppointmentScreen(navController: NavHostController) {
    // Context and repository initialization
    val context = LocalContext.current
    val productRepository = appointmentviewmodel(navController, context)
    val emptyProductState = remember { mutableStateOf(Appointment("", "", "", "")) }
    val emptyProductsListState = remember { mutableStateListOf<Appointment>() }

    // Fetch products
    val products = productRepository.viewProducts(emptyProductState, emptyProductsListState)

    // Screen layout
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display Image
        Image(
            painter = painterResource(id = R.drawable.picture), // Replace with your image resource
            contentDescription = "Appointment Image",
            modifier = Modifier
                .size(100.dp) // Adjust size as needed
                .padding(16.dp)
        )

        // Display Title Text
        Text(
            text = "My Appointments",
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Blue
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Display List of Appointments
        LazyColumn {
            items(products) { product ->
                AppointmentItem(
                    name = product.name,
                    quantity = product.quantity,
                    price = product.price,
                    id = product.id,
                    navController = navController,
                    productRepository = productRepository
                )
            }
        }
    }
}


@Composable
fun AppointmentItem(
    name: String,
    quantity: String,
    price: String,
    id: String,
    navController: NavHostController,
    productRepository: appointmentviewmodel
) {
    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Text(text = name)
        Text(text = quantity)
        Text(text = price)

        // Button with blue color
        Button(
            onClick = {
                productRepository.deleteProduct(id)
            },
            colors = ButtonDefaults.buttonColors(Color.Blue) // Set button color to blue
        ) {
            Text(text = "Delete", color = Color.White) // Set text color to white for contrast
        }
    }
}


@Preview
@Composable
fun View() {
    ViewAppointmentScreen(rememberNavController())

}
