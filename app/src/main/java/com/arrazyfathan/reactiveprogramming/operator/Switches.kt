package com.arrazyfathan.reactiveprogramming.operator

import com.arrazyfathan.reactiveprogramming.utils.exampleOf
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.subjects.PublishSubject

/**
 * Created by Ar Razy Fathan Rabbani on 16/11/22.
 */

fun switchesUsingAmb() {
    exampleOf("amb") {
        val disposable = CompositeDisposable()

        val left = PublishSubject.create<String>()
        val right = PublishSubject.create<String>()

        left.ambWith(right)
            .subscribeBy {
                println(it)
            }
            .addTo(disposable)

        left.onNext("Lisbon")
        right.onNext("Copenhagen")
        left.onNext("London")
        left.onNext("Madrid")
        right.onNext("Vienna")
    }
}

fun main() {
    switchesUsingAmb()
}
