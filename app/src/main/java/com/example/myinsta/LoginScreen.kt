package com.example.myinsta

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun LoginScreen(
    navController: NavController,
){
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopBar()
        InstaLogo()
        InputField("Email")
        Spacer(modifier = Modifier.padding(10.dp))
        PasswordField()
        Spacer(modifier = Modifier.padding(10.dp))
        ForgetPassword()
        Spacer(modifier = Modifier.padding(15.dp))
        Btn("Login",Screen.Bottom.route,navController)
        Spacer(modifier = Modifier.padding(20.dp))
        SignUpBtn(Screen.SignUp.route,navController)
    }
}

@Composable
fun TopBar(
    modifier: Modifier = Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
    ){
        Icon(imageVector = Icons.Default.KeyboardArrowLeft,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun InstaLogo(
    modifier: Modifier = Modifier
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
    ) {

        Icon(painter = painterResource(id = R.drawable.instagram_logo_login_screen),
            contentDescription ="InstagramLogo",
            tint= Color.Unspecified,
            modifier = Modifier
                .height(150.dp)
                .padding(40.dp)
        )
    }
}

@Composable
fun InputField(
    string: String,
    modifier: Modifier = Modifier,
) {
    var textState by remember { mutableStateOf("") }
    OutlinedTextField(
        value = textState,
        onValueChange = { textState = it },
        shape = RoundedCornerShape(8.dp),
        placeholder = {Text(text = string)},
        label = { Text(text = string) },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp),
    )
}

@Composable
fun PasswordField(){
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Password") },
        singleLine = true,
        placeholder = { Text("Password") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp),
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (passwordVisible)
                Icons.Filled.Visibility
            else Icons.Filled.VisibilityOff

            // Please provide localized description for accessibility services
            val description = if (passwordVisible) "Hide password" else "Show password"

            IconButton(onClick = {passwordVisible = !passwordVisible}){
                Icon(imageVector  = image, description)
            }
        }
    )
}

@Composable
fun OneTimeClickableText(text : String, onClick : () -> Unit){
    var enabled by rememberSaveable{ mutableStateOf(true)}
    Text(
        modifier = Modifier
            .clickable(enabled = enabled) {
                enabled = false
                onClick()
            },
        text = text,
        style = TextStyle(Color(0xFF6495ED)),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun ForgetPassword(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(end = 24.dp),
        horizontalArrangement = Arrangement.End) {
        OneTimeClickableText(text = "Forgot password?",{})
    }
}

@Composable
fun Btn(
    string: String,
    path: String,
    navController: NavController
){
    Button(onClick = {
        navController.navigate(path)
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
fun SignUpBtn(
    path: String,
    navController: NavController
){
    Row(horizontalArrangement = Arrangement.Center,
        modifier = Modifier
        .fillMaxWidth()){
        Text(text ="Don't have an aacount? ",
            textAlign = TextAlign.Center,
        )
        OneTimeClickableText("Sign Up.",{
            navController.navigate(path)
        })
    }
}

@Composable
@Preview(showBackground = true)
fun LoginScreenPreview(){
    LoginScreen(
        navController = rememberNavController()
    )
}


