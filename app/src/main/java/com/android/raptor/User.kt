package com.android.raptor

/**
 * Created by fsfaysalcse on 4/7/22.
 * Email : fsfoysal15@gmail.com
 */
data class User(
    val name : String,
    val email : String
)

fun mockUserData() = listOf<User>(
    User("Mark","mark@dev.com"),
    User("Larry","larry@dev.com"),
    User("Amber Mam","mam@dev.com"),
    User("Aaron","aaron@dev.com"),
    User("Thomas Woodfin","thomas@dev.com"),
    User("Warren","thomas@dev.com"),
    User("Kyle","thomas@dev.com"),
    User("Ramond","thomas@dev.com"),
    User("More","thomas@dev.com"),
    User("James","james@dev.com")
)

