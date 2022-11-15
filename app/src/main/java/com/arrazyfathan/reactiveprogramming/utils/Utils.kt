package com.arrazyfathan.reactiveprogramming.utils

/**
 * Created by Ar Razy Fathan Rabbani on 15/11/22.
 */
fun exampleOf(description: String, action: () -> Unit) {
    println("\n--- Example of: $description ---")
    action()
}