package com.example.birthdaycard


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.birthdaycard.ui.theme.BirthdayCardTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BirthdayCardTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    GreetingImage(Message = "HBD", From = "Els", Modifier)
                }
            }
        }
    }
}

@Composable
fun GreetingImage(Message:String,From:String,modifier: Modifier){
    val greetingImage = painterResource(R.drawable.androidparty)
    Box ( modifier = Modifier){
        Image(
            painter = greetingImage,
            contentDescription = null,//es el equivalente al alt, pero en este caso como es decorativa no lleva
            contentScale = ContentScale.Crop,
            alpha = 0.9F
        )
        GreetingText(stringResource(R.string.hbd_2_u),"Els",Modifier.padding(8.dp))
    }
}
@Composable
fun GreetingText(message:String,from:String,modifier: Modifier){
    Column (verticalArrangement = Arrangement.Center, modifier = modifier
        .fillMaxSize()
        .padding(8.dp)){
        //buena práctica: incremento de padding cada 4dp
        Text(
            message,
            fontSize = 100.sp, //pixeles escalables
            lineHeight = 116.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = stringResource(R.string.de_parte_de, from),
            fontSize = 36.sp,
            modifier = Modifier
                .padding(18.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }

}

fun Modifier.Companion.align(alignment: Alignment) {}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    BirthdayCardTheme {
        GreetingImage("HBD","Els",Modifier)
    }
}