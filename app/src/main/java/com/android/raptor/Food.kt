package com.android.raptor

/**
 * Created by fsfaysalcse on 6/7/22.
 * Email : fsfoysal15@gmail.com
 */


data class Food(
    val name : String,
    val foodImage : String,
    val price : Double
)

fun mockFoodData() = listOf<Food>(
    Food(
        name = "Burger",
        price = 10.6,
        foodImage = "https://www.thespruceeats.com/thmb/vJUFf6L4p8y9Cn_1pE9Z7Ua9uok=/3000x2001/filters:fill(auto,1)/indian-style-burger-1957599-hero-01-266103a4bb4e4ee7b5feb4da2d2e99da.jpg"
    ),

    Food(
        name = "Pasta",
        price = 20.11,
        foodImage = "https://food.fnr.sndimg.com/content/dam/images/food/fullset/2021/02/05/Baked-Feta-Pasta-4_s4x3.jpg.rend.hgtvcom.406.325.suffix/1615916524567.jpeg"
    ),

    Food(
        name = "French Fries",
        price = 7.9,
        foodImage = "https://static.toiimg.com/thumb/54659021.cms?width=1200&height=900"
    ),

    Food(
        name = "Ice Cream",
        price = 5.6,
        foodImage = "https://cdn.britannica.com/50/80550-050-5D392AC7/Scoops-kinds-ice-cream.jpg"
    ),

)
