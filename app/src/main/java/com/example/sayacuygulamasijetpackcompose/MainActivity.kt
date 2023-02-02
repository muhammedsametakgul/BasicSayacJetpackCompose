package com.example.sayacuygulamasijetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sayacuygulamasijetpackcompose.ui.theme.SayacUygulamasiJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SayacUygulamasiJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AnaSayfa()
                }
            }
        }
    }
}

@Composable
fun AnaSayfa() {
    val sayac =remember{mutableStateOf(0)}
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement =Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Sayaç :  ${sayac.value}")
        Spacer(modifier = Modifier.padding(10.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = { if (sayac.value>0){
                sayac.value=sayac.value-1
            } },Modifier.size(80.dp,50.dp)) {
                Text(text = "Azalt")

            }
            Button(onClick = { if (sayac.value>=0){
                sayac.value=sayac.value+1
            } },Modifier.size(80.dp,50.dp)) {
                Text(text = "Arttır")

            }



        }
        Button(onClick = { sayac.value=0},Modifier.padding(30.dp)) {
            Text(text = "Sıfırla")

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SayacUygulamasiJetpackComposeTheme {
        AnaSayfa()
    }
}