package com.android.raptor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.raptor.R
import com.android.raptor.ui.theme.RaptorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RaptorTheme {


            }
        }
    }
}


@Composable
fun HomePage() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.Cyan
    ) {

        Card(
            modifier = Modifier
                .padding(30.dp)
                .fillMaxWidth()
                .height(500.dp),
            backgroundColor = Color.White,
            shape = RoundedCornerShape(30.dp),
            elevation = 20.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_thomas_sir) ,
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .border(
                            width = 3.dp,
                            color = Color.Blue,
                            shape = CircleShape
                        ),
                    contentScale = ContentScale.Crop
                )


                Text(
                    text = "Thomas Woodfin",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Medium,
                        fontStyle = FontStyle.Normal,
                        fontFamily = SplashFont
                    )
                )


                Text(
                    text = "Software Engineer",
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal,
                        fontFamily = Manrope
                    )
                )


                Text(
                    text = "Blood Group : AB+",
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        fontStyle = FontStyle.Normal,
                        fontFamily = Manrope
                    )
                )


                Text(
                    text = "tom@hire-programmers.com",
                    style = TextStyle(
                        color = Color.Magenta,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        fontStyle = FontStyle.Normal,
                        fontFamily = Manrope
                    )
                )

            }
        }








    }
}

@Preview
@Composable
fun HomePagePreview() {
    HomePage()
}


