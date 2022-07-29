package com.arrazyfathan.rxjavaplayground.sample.data

/**
 * Created by Ar Razy Fathan Rabbani on 29/07/22.
 */
data class User(
    val id: Long,
    val name: String,
    val age: Int
) {

    override fun toString(): String {
        return """
            {
                id: $id,
                name: $name,
                age: $age
            }
        """.trimIndent()
    }
}

val mUserList = mutableListOf(
    User(1, "demo1", 15),
    User(2, "demo2", 12),
    User(3, "demo3", 43),
    User(4, "demo4", 46),
    User(5, "demo5", 65),
    User(6, "demo6", 65),
    User(7, "demo7", 65),
    User(8, "demo8", 65)
)
