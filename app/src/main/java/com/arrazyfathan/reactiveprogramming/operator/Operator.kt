package com.arrazyfathan.reactiveprogramming.operator

import com.arrazyfathan.reactiveprogramming.utils.exampleOf
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.subjects.PublishSubject

/**
 * Created by Ar Razy Fathan Rabbani on 16/11/22.
 */

/*
* Ignored Element
* Ignore next event element
* Ignore element is useful when you only want to be notified when an observable has terminated
* via onComplete or onError
* */
fun operatorIgnoredElement() {
    exampleOf("Ignored Element") {
        val subscriptions = CompositeDisposable()

        val strikes = PublishSubject.create<String>()

        subscriptions.add(
            strikes.ignoreElements()
                .subscribeBy {
                    println("You are out")
                }
        )

        strikes.onNext("X")
        strikes.onNext("X")
        strikes.onNext("X")
        strikes.onComplete()
    }
}

/*
* Operator elementAt
* Operator elementAt takes the index of the element you want to receive and it ignores everything else
*  */
fun operatorElementAt() {
    exampleOf("Operator elementAt") {
        val subscriptions = CompositeDisposable()
        val strikes = PublishSubject.create<String>()
        subscriptions.add(
            strikes.elementAt(2)
                .subscribeBy(
                    onSuccess = { println("You are out!, $it") }
                )
        )

        strikes.onNext("1")
        strikes.onNext("2")
        strikes.onNext("3")
        strikes.onNext("4")
    }
}

fun main() {
    operatorElementAt()
}
