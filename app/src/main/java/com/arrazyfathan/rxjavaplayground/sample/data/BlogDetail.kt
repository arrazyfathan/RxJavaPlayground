package com.arrazyfathan.rxjavaplayground.sample.data

/**
 * Created by Ar Razy Fathan Rabbani on 02/08/22.
 */
data class BlogDetail(
    val id: Long,
    val userId: Long,
    val title: String,
    val content: String,
    val user: User
)