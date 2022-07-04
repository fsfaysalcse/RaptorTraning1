package com.android.raptor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.raptor.ui.theme.RaptorTheme
import java.util.*

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RaptorTheme {
                ListActivityUI()
            }
        }
    }
}


@Composable
fun ListActivityUI() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        ShowList()
    }
}


@Composable
private fun ShowList() {
    val dataSet = mockUserData()

    LazyColumn(
        content = {
            itemsIndexed(dataSet) { index, item ->
                UserItem(item)
            }
        },
        modifier = Modifier.padding(all = 16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)

    )
}

@Composable
fun UserItem(user: User) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.weight(0.2f),
            contentAlignment = Alignment.Center
        ) {

            val random = Random()
            val color: Int = android.graphics.Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))


            Box(
                modifier = Modifier
                    .size(60.dp)
                    .background(Color(color.toLong()) ,CircleShape),
                contentAlignment = Alignment.Center
            ) {

                val firstChar = user.name.first()

                Text(
                    text = firstChar.toString(),
                    style = TextStyle(
                        color = Color.White,
                        fontFamily = Manrope,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }

        Column(
            modifier = Modifier
                .weight(0.8f)
                .fillMaxHeight()
                .padding(horizontal = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = user.name,
                style = TextStyle(
                    color = Color.Black,
                    fontFamily = Manrope,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                ),
                modifier = Modifier.fillMaxWidth(),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis

            )
            Text(
                text = user.email,
                style = TextStyle(
                    color = Color.Black.copy(alpha = 0.6f),
                    fontFamily = Manrope,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                ),
                modifier = Modifier.fillMaxWidth(),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview
@Composable
fun previewShowList() {
    RaptorTheme {
        ListActivityUI()
    }
}


