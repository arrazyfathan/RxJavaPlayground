package com.arrazyfathan.rxjavaplayground.sample.data

/**
 * Created by Ar Razy Fathan Rabbani on 29/07/22.
 */
data class UserProfile(
    val id: Long,
    val name: String,
    val age: Int,
    val image: String
)

val mUserProfileList = mutableListOf(
    UserProfile(1, "demo1", 15, "https://test/com/1"),
    UserProfile(2, "demo2", 12, "https://test/com/2"),
    UserProfile(3, "demo3", 34, "https://test/com/3"),
    UserProfile(4, "demo4", 54, "https://test/com/4"),
    UserProfile(5, "demo5", 23, "https://test/com/5"),
    UserProfile(6, "demo6", 55, "https://test/com/6"),
    UserProfile(7, "demo7", 22, "https://test/com/7")
)
