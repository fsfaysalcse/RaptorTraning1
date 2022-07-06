package com.android.raptor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.android.raptor.ui.theme.RaptorTheme
import java.util.*

class RowActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RaptorTheme {
                // A surface container using the 'background' color from the theme
                FoodsView()
            }
        }
    }
}

@Composable
fun FoodsView() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        color = MaterialTheme.colors.background
    ) {
        FoodContent()
    }
}


@Composable
fun FoodContent() {

    val listOfFoods = mockFoodData()

    LazyRow(
        content = {
            itemsIndexed(listOfFoods) { index, item ->
                FoodItem(food = item)
            }

        },
        horizontalArrangement = Arrangement.SpaceBetween
    )
}

@Composable
fun FoodItem(food: Food) {

    val random = Random()
    val color: Int = android.graphics.Color.argb(
        255,
        random.nextInt(256),
        random.nextInt(256),
        random.nextInt(256)
    )


    Box(
        modifier = Modifier
            .size(
                height = 250.dp,
                width = 230.dp
            )
            .padding(10.dp)
            .background(
                color = Color(color.toLong()).copy(alpha = 0.2f),
                shape = RoundedCornerShape(15.dp)
            )
    ) {


        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = rememberAsyncImagePainter(food.foodImage),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = food.name,
                    style = TextStyle(
                        color = Color.Black,
                        fontFamily = Manrope,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp
                    ),
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp, vertical = 10.dp)
                        .align(Alignment.Start),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Row(
                    modifier = Modifier
                        .padding(horizontal = 15.dp, vertical = 5.dp)
                ) {
                    Text(
                        text = " $${food.price}",
                        style = TextStyle(
                            color = Color(0xFFE28C40),
                            fontFamily = Manrope,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp
                        ),
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.4f),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .weight(0.1f)
                            .background(
                                Color(0xFFFAE4CD),
                                CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_add_24),
                            contentDescription = null,
                            tint = Color(0xFFE28C40)
                        )
                    }

                }
            }
        }

        Box(
            modifier = Modifier
                .size(40.dp)
                .padding(30.dp)
                .background(
                    Color(0xFFFAE4CD),
                    CircleShape
                )
                .padding(10.dp)
                .align(Alignment.TopEnd),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_favorite_border_24),
                contentDescription = null,
                tint = Color(0xFFE28C40)
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RaptorTheme {
        FoodsView()
    }
}