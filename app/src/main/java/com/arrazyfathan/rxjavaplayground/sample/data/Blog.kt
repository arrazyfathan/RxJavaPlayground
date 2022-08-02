package com.arrazyfathan.rxjavaplayground.sample.data

/**
 * Created by Ar Razy Fathan Rabbani on 02/08/22.
 */
data class Blog(
    val id: Long,
    val userId: Long,
    val title: String,
    val content: String
)

val mBlogList = mutableListOf(
    Blog(1, 1, "title1", "content1"),
    Blog(2, 2, "title2", "content2"),
    Blog(3, 2, "title3", "content3"),
    Blog(4, 2, "title4", "content4"),
    Blog(5, 3, "title5", "content5"),
    Blog(6, 3, "title6", "content6"),
    Blog(7, 13, "title7", "content7")
)