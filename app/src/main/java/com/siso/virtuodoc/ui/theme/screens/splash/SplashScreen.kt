package com.siso.virtuodoc.ui.theme.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.siso.virtuodoc.R
import com.siso.virtuodoc.navigation.ROUTE_HOME
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    //delay to simulate splash screen duration
    LaunchedEffect(Unit) {
        delay(1000) //1 seconds delay
        navController.navigate(ROUTE_HOME)

    }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        contentAlignment = Alignment.Center){
        Image(painter = painterResource(id = R.drawable.picture),
            contentDescription = "Splash Logo",
            modifier = Modifier.size(200.dp))
    }

}

@Preview
@Composable
private fun spprev() {
    SplashScreen(rememberNavController())

}