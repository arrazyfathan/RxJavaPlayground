package com.arrazyfathan.reactiveprogramming

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.subscribeBy

/**
 * Created by Ar Razy Fathan Rabbani on 15/11/22.
 */

fun exampleOf(description: String, action: () -> Unit) {
    println("\n--- Example of: $description ---")
    action()
}

fun main() {
    exampleOf("just") {
        val observable = Observable.just(listOf(1, 2, 3))
    }

    exampleOf("fromIterable") {
        val observable: Observable<Int> = Observable.fromIterable(listOf(1, 2, 3, 4))

        observable.subscribe {
            println(it)
        }   
    }

    exampleOf("empty") {
        val observable = Observable.empty<Unit>()

        observable.subscribeBy(
            onNext = {
                println(it)
            },
            onComplete = {
                println("Completed")
            }
        )
    }
}
