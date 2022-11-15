package com.arrazyfathan.reactiveprogramming.subject

import com.arrazyfathan.reactiveprogramming.utils.exampleOf
import com.jakewharton.rxrelay3.PublishRelay
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.subjects.AsyncSubject
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.ReplaySubject

/**
 * Created by Ar Razy Fathan Rabbani on 15/11/22.
 */

/**
 * Subject
 *
 * Subject act as both observable and an observer. The subject receive next event and each time it receive an event.
 * it turned around and emitted it to its subscriber.
 * */

/*
  * PublishSubject
  * Start Empty and only emits new element to subscriber
  * */
fun publishSubject() {
    exampleOf("PublishSubject") {
        val publishSubject = PublishSubject.create<Int>()
        publishSubject.onNext(0)

        val subscriptionOne = publishSubject.subscribe { int -> println(int) }
        publishSubject.onNext(1)
        publishSubject.onNext(2)
        val subscribeTwo = publishSubject
            .subscribe { int ->
                println("2), $int")
            }
        publishSubject.onNext(3)
        subscriptionOne.dispose()
        publishSubject.onNext(4)
        publishSubject.onComplete()
        publishSubject.onNext(5)
        subscribeTwo.dispose()

        val subscribeThree = publishSubject.subscribeBy(
            onNext = { println("3), $it") },
            onComplete = { println("3), Complete") }
        )

        publishSubject.onNext(6)
    }
}

/*
* BehaviorSubject
* Start with an optional initial value and replays it or the latest element to new subscriber
* */
fun behaviorSubject() {
    exampleOf("BehaviorSubject") {
        val subscription = CompositeDisposable()
        val behaviorSubject = BehaviorSubject.createDefault("Initial value")
        behaviorSubject.onNext("X")
        val subscriptionOne = behaviorSubject.subscribeBy(
            onNext = { println("1), $it") },
            onError = { println("1), $it") }
        )
        behaviorSubject.onError(RuntimeException("Error!"))
        subscription.add(
            behaviorSubject.subscribeBy(
                onNext = { println("2), $it") },
                onError = { println("2), $it") }
            )
        )
    }
}

fun behaviorSubjectState() {
    exampleOf("Behavior Subject State") {
        val subscription = CompositeDisposable()
        val behaviorSubject = BehaviorSubject.createDefault(0)
        println(behaviorSubject.value!!)

        subscription.add(
            behaviorSubject.subscribeBy {
                println("1), $it")
            }
        )

        behaviorSubject.onNext(1)
        println(behaviorSubject.value!!)
        subscription.dispose()
    }
}

/*
* ReplaySubject
* Initialized with a buffer size and will maintain a buffer of element up that size and replay it to new subscriber
* */
fun replaySubject() {
    exampleOf("ReplaySubject") {
        val subscription = CompositeDisposable()
        val replaySubject = ReplaySubject.createWithSize<Int>(2)

        replaySubject.onNext(1)
        replaySubject.onNext(2)
        replaySubject.onNext(3)

        subscription.add(
            replaySubject.subscribeBy(
                onNext = { println("1), $it") },
                onError = { println("1), $it") }
            )
        )

        subscription.add(
            replaySubject.subscribeBy(
                onNext = { println("2), $it") },
                onError = { println("2), $it") }
            )
        )

        replaySubject.onNext(4)
        replaySubject.onError(RuntimeException("Error!"))

        subscription.add(
            replaySubject.subscribeBy(
                onNext = { println("3), $it") },
                onError = { println("3), $it") }
            )
        )
    }
}

/*
* AsyncSubject
* Start empty and only emit the last item it receives befor its completed to subscriber.
* */
fun asyncSubject() {
    val subscripsion = CompositeDisposable()
    val asyncSubject = AsyncSubject.create<Int>()

    subscripsion.add(
        asyncSubject.subscribeBy(
            onNext = { println("1), $it") },
            onComplete = { println("1), Complete") }
        )
    )

    asyncSubject.onNext(0)
    asyncSubject.onNext(1)
    asyncSubject.onNext(2)
    asyncSubject.onComplete()
    subscripsion.dispose()
}

/**
 * RxRelay
 * mimics all of the subject you have come to know and love, but without the option of calling onComplete or onError
 * */
fun rxRelay() {
    exampleOf("RxRelay") {
        val subscriptions = CompositeDisposable()
        val publishRelay = PublishRelay.create<Int>()

        subscriptions.add(
            publishRelay.subscribeBy(
                onNext = { println("1), $it") }
            )
        )

        publishRelay.accept(1)
        publishRelay.accept(2)
        publishRelay.accept(3)
    }
}

fun main() {
    rxRelay()
}
