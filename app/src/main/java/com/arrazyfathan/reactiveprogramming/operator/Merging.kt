package com.arrazyfathan.reactiveprogramming.operator

import com.arrazyfathan.reactiveprogramming.utils.exampleOf
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.subjects.PublishSubject

/**
 * Created by Ar Razy Fathan Rabbani on 16/11/22.
 */

/*   Merging    */

/*
* merge
* emits the item in the order that they come in from different observable
* */
fun mergingUsingMerge() {
    exampleOf("merge") {
        val disposable = CompositeDisposable()
        val left = PublishSubject.create<Int>()
        val right = PublishSubject.create<Int>()

        Observable.merge(left, right)
            .subscribeBy {
                println(it)
            }
            .addTo(disposable)

        left.onNext(1)
        left.onNext(2)
        left.onNext(3)
        right.onNext(4)
        right.onNext(5)
        left.onNext(6)
    }
}

/*
* mergeWith
*
* */
fun mergingUsingMergeWith() {
    exampleOf("mergeWith") {
        val disposable = CompositeDisposable()
        val germanCities = PublishSubject.create<String>()
        val spanishCities = PublishSubject.create<String>()

        germanCities.mergeWith(spanishCities)
            .subscribeBy { cities ->
                println(cities)
            }
            .addTo(disposable)

        germanCities.onNext("Munich")
        spanishCities.onNext("Barcelona")
        germanCities.onNext("Munich")
        germanCities.onNext("Hamburg")
        spanishCities.onNext("Madrid")
        spanishCities.onNext("Valencia")
    }
}

fun main() {
    mergingUsingMergeWith()
}
