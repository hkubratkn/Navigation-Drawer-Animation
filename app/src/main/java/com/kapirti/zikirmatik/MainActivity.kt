package com.kapirti.zikirmatik

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kapirti.zikirmatik.ui.theme.ZikirmatikTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZikirmatikTheme {
                NavigationDrawer()
                BodyContent()
            }
        }
    }
}

@Composable
fun BodyContent(){
    var navigateClick by remember{ mutableStateOf(false)}
    val offSetAnim by animateDpAsState(targetValue = if (navigateClick) 253.dp else 0.dp)
    val scaleAnim by animateFloatAsState(targetValue = if (navigateClick) 0.6f else 1.0f)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .scale(scaleAnim)
            .offset(x = offSetAnim)
            .clip(if (navigateClick) RoundedCornerShape(30.dp) else RoundedCornerShape(0.dp))
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 55.dp, start = 45.dp, end = 30.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription ="menu",
                modifier = Modifier
                    .clickable { navigateClick = !navigateClick }
                    .padding(15.dp)
            )
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text ="drawer menu",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp
            )
        }

    }
}

@Composable
fun NavigationDrawer(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary)
    ){
        NavigationItem(
            resId =R.drawable.ic_launcher_background,
            text ="profile",
            topPadding = 145.dp
        ){}
        NavigationItem(
            resId = R.drawable.ic_launcher_foreground,
            text = "Textttt",
            itemClicked = {
                val intent = Intent()
                intent.action=Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT,"lalalaa")
                intent.type="text/plain"
                context.startActivity(Intent.createChooser(intent, "gegegegeg"))
            }
        )
        NavigationItem(
            resId = R.drawable.ic_launcher_background,
            text = "heheekekskd",
            itemClicked = {
                Toast.makeText(context, "oldu mu", Toast.LENGTH_LONG).show()
            }
        )

        Row(
            modifier = Modifier
                .padding(start = 50.dp, bottom = 87.dp)
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.Bottom
        ){
            Text(
                text = "sign out",
                color = Color.White,
                fontSize = 17.sp
            )
            Image(
                imageVector = Icons.Filled.ArrowForward,
                contentDescription = "Logout",
                colorFilter = ColorFilter.tint(Color.White)
            )
        }
    }
}

@Composable
fun NavigationItem(
    resId : Int,
    text : String,
    topPadding : Dp = 20.dp,
    destination : String = "",
    itemClicked : (String) -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 38.dp, top = topPadding)
            .clickable { itemClicked(destination) }
    ){
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ){
            Image(
                painter = painterResource(id = resId),
                contentDescription = "item image",
                modifier = Modifier.size(30.dp)
            )
            Text(
                text = text,
                color = Color.White,
                fontSize = 16.sp
            )
        }

        Box(
            modifier = Modifier
                .padding(start = 35.dp, top = 26.dp, bottom = 16.dp)
                .size(120.dp, 0.5.dp)
                .background(Color.Gray)
        )
    }

}
