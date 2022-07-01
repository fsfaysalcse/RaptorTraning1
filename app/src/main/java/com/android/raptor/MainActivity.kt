package com.android.raptor

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.android.raptor.ui.theme.Purple700

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomePageScreen()

        }
    }
}

@Composable
fun HomePageScreen() {
    Scaffold(
        bottomBar = { HomeBottomMenu() }
    ) {

    }
}

@Composable
fun HomeBottomMenu() {

    val context = LocalContext.current

    val selectedItem = remember { mutableStateOf(0) }

    val items = listOf<MenuItem>(
        MenuItem("Favourite", R.drawable.ic_baseline_favorite_24),
        MenuItem("Music", R.drawable.ic_baseline_music_note_24),
        MenuItem("Place", R.drawable.ic_baseline_place_24),
        MenuItem("News", R.drawable.ic_baseline_fiber_new_24),
    )

    BottomNavigation(
        backgroundColor = Purple700
    ) {
        items.forEachIndexed { index, menuItem ->
            BottomNavigationItem(
                selected = selectedItem.value == index,
                onClick = {
                    selectedItem.value = index
                    Toast.makeText(context, "Clicked on ${menuItem.title}", Toast.LENGTH_SHORT)
                        .show()
                },
                icon = {
                    Icon(
                        painter = painterResource(id = menuItem.icon),
                        contentDescription = null,
                        tint = Color.Red
                    )
                },
                label = {
                    Text(
                        text = menuItem.title,
                        style = TextStyle(
                            fontSize = 13.sp,
                            fontFamily = SplashFont,
                            color = Color.Red
                        )
                    )
                },
                alwaysShowLabel = true

            )
        }

    }

}

data class MenuItem(
    val title: String,
    val icon: Int
)

@Preview
@Composable
fun HomePagePreview() {
    HomePageScreen()
}


/*@Composable
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
}*/



