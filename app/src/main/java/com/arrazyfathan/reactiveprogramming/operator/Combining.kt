package com.arrazyfathan.reactiveprogramming.operator

import com.arrazyfathan.reactiveprogramming.utils.exampleOf
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo

/**
 * Created by Ar Razy Fathan Rabbani on 16/11/22.
 */

/*
* Prefixing and Concatenating
*/

/*
* startWith
*
*/
fun combiningUsingStartWith() {
    exampleOf("startWith") {
        val disposable = CompositeDisposable()
        val missingNumber = Observable.just(3, 4, 5)
        val completeSet = missingNumber.startWithIterable(listOf(1, 2))
        completeSet
            .subscribe { number ->
                println(number)
            }
            .addTo(disposable)
    }
}

fun main() {
    combiningUsingStartWith()
}
