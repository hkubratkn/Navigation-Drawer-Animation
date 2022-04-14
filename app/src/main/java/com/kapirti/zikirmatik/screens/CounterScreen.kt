package com.kapirti.zikirmatik.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.kapirti.zikirmatik.ui.theme.ZikirmatikTheme

@Composable
fun CounterScreenCompos(){
    ZikirmatikTheme{
        Surface(
            color= MaterialTheme.colors.background
        ){
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text="Counter screen"
                )
                Row{
                    Button(onClick = { /*TODO*/ }) {
                        Text(text="0")
                    }
                    Button(onClick = { /*TODO*/ }) {
                        Text(text="+")
                    }
                }
            }

        }
    }
}