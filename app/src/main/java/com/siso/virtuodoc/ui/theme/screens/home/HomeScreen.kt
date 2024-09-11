package com.siso.virtuodoc.ui.theme.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.siso.virtuodoc.R
import com.siso.virtuodoc.navigation.ROUTE_BOOK_APPOINTMENT
import com.siso.virtuodoc.navigation.ROUTE_LOGIN
import com.siso.virtuodoc.navigation.ROUTE_REGISTER
import com.siso.virtuodoc.navigation.ROUTE_VIEW_APPOINTMENT

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = { },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "VirtuoDoc",
                    color = Color.Blue,
                    fontSize = 50.sp,
                    fontFamily = FontFamily.Default
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Insert the Image here
                val image: Painter = painterResource(id = R.drawable.picture)  // Replace 'your_image' with your actual image name
                Image(
                    painter = image,
                    contentDescription = null, // Provide a meaningful description for accessibility
                    modifier = Modifier
                        .size(300.dp)  // Adjust size as needed
                        .padding(8.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Your Health Our Priority",
                    color = Color.Blue,
                    fontFamily = FontFamily.Serif,
                    fontSize = 30.sp
                )

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = { navController.navigate(ROUTE_LOGIN) },
                    modifier = Modifier.width(350.dp),
                    colors = ButtonDefaults.buttonColors(Color.Blue, contentColor = Color.White),
                    shape = CircleShape
                ) {
                    Text(text = "Log in here")
                }

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = { navController.navigate(ROUTE_REGISTER) },
                    modifier = Modifier.width(350.dp),
                    colors = ButtonDefaults.buttonColors(Color.Blue, contentColor = Color.White),
                    shape = CircleShape
                ) {
                    Text(text = "Don't have an account, create one here")
                }

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = { navController.navigate(ROUTE_BOOK_APPOINTMENT) },
                    modifier = Modifier.width(350.dp),
                    colors = ButtonDefaults.buttonColors(Color.Blue, contentColor = Color.White),
                    shape = CircleShape
                ) {
                    Text(text = "Book an appointment with our Doctors")
                }

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = { navController.navigate(ROUTE_VIEW_APPOINTMENT) },
                    modifier = Modifier.width(350.dp),
                    colors = ButtonDefaults.buttonColors(Color.Blue, contentColor = Color.White),
                    shape = CircleShape
                ) {
                    Text(text = "View Your Upcoming Appointments")
                }
            }
        },
        bottomBar = { BottomBar() }
    )
}
@Composable
fun BottomBar() {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(elevation = 10.dp) {

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Home,"")
        },
            label = { Text(text = "Home") },
            selected = (selectedIndex.value == 0),
            onClick = {
                selectedIndex.value = 0
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Favorite,"")
        },
            label = { Text(text = "Favorite") },
            selected = (selectedIndex.value == 1),
            onClick = {
                selectedIndex.value = 1
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Call,"")
        },
            label = { Text(text = "Contact Us") },
            selected = (selectedIndex.value == 2),
            onClick = {
                selectedIndex.value = 2
            })
    }
}

@Preview
@Composable
private fun Homeprev() {
    HomeScreen(rememberNavController())

}