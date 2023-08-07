package com.example.myinsta

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SignUpScreen(
    navController: NavController
){
    Column(
        modifier = Modifier
            .fillMaxSize()
    ){
        TopBar()
        InstaLogo()
        InputField("First Name")
        Spacer(modifier = Modifier.padding(10.dp))
        InputField("Last Name")
        Spacer(modifier = Modifier.padding(10.dp))
        InputField("Email")
        Spacer(modifier = Modifier.padding(10.dp))
        PasswordField()
        Spacer(modifier = Modifier.padding(15.dp))
        Btn2("SignUp" )
        Spacer(modifier = Modifier.padding(20.dp))
        LoginBtn(Screen.Login.route,navController)
    }
}

@Composable
fun Btn2(
    string: String,
){
    Button(onClick = {
        //navController.popBackStack()
        //navController.navigate(path)
    },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF6495ED),
            contentColor = Color.White)
    ){
        Text(text =string,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun LoginBtn(
    path: String,
    navController: NavController
){
    Row(horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()){
        Text(text ="Already sign up? ",
            textAlign = TextAlign.Center,
        )
        OneTimeClickableText("SignIn.",{
            navController.navigate(path)
        })
    }
}

@Composable
@Preview(showBackground = true)
fun SignUpScreenPreview() {
    SignUpScreen(
        navController = rememberNavController()
    )
}
